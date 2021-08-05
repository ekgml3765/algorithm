package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2589_보물섬 {
	static class Node{
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}	
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'L') {
					Queue<Node> queue = new LinkedList<Node>();
					boolean visit[][] = new boolean[N][M];
					queue.add(new Node(i, j, 0));
					visit[i][j] = true;
					int max = 0;
					while(!queue.isEmpty()) {
						Node node = queue.poll();
						max = Math.max(max, node.cnt);
						for (int d = 0; d < 4; d++) {
							int nr = node.r + dr[d];
							int nc = node.c + dc[d];
							if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] == 'W')
								continue;
							visit[nr][nc] = true;
							queue.add(new Node(nr, nc, node.cnt+1));
						}
					}
					ans = Math.max(ans, max);
				}
			}
		}// end for
		System.out.println(ans);
	}
}
