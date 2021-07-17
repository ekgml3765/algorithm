package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178_미로탐색 {

	static class Node{
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		int dr[] = {-1, 1, 0, 0};
		int dc[] = {0, 0, -1, 1};
		Queue<Node> queue = new LinkedList<Node>();
		boolean visited[][] = new boolean[N][M];
		queue.add(new Node(0, 0, 1));
		visited[0][0] = true;
		int ans = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.r == N-1 && node.c == M-1) {
				ans = node.cnt;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if(nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && map[nr][nc] != 0) {
					visited[nr][nc] = true;
					queue.add(new Node(nr, nc, node.cnt+1));
				}
			}
		}//end while
		System.out.println(ans);
	}
}
