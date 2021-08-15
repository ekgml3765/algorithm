package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2206_벽부수고이동하기 {

	static class Node{
		int r, c, cnt;
		boolean flag = false;
		public Node(int r, int c, int cnt, boolean flag) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.flag = flag;
		}
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		boolean visit[][][] = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		int ans = -1;
		Queue<Node> queue = new LinkedList<Node>();
		visit[0][0][0] = true;
		queue.add(new Node(0, 0, 1, false));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.r == N-1 && node.c == M-1 ) {
				ans = node.cnt;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc][(node.flag==false)? 0:1])
					continue;
				if(map[nr][nc] == 0) {
					visit[nr][nc][(node.flag==false)? 0:1] = true;
					queue.add(new Node(nr, nc, node.cnt+1, node.flag));
				}
				if(map[nr][nc] == 1 && !node.flag) {
					visit[nr][nc][(node.flag==false)? 0:1] = true;
					queue.add(new Node(nr, nc, node.cnt+1, true));
				}
			}
		}
		System.out.println(ans);
	}
}
