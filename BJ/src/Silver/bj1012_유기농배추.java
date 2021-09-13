package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1012_유기농배추 {
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int map[][] = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int X = Integer.parseInt(st.nextToken()); 
				int Y = Integer.parseInt(st.nextToken()); 
				map[Y][X] = 1;
			}
			boolean visit[][] = new boolean[N][M];
			Queue<Point> queue = new LinkedList<Point>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						ans++;
						visit[i][j] = true;
						queue.add(new Point(i, j));
						while(!queue.isEmpty()) {
							Point p = queue.poll();
							for (int d = 0; d < 4; d++) {
								int nr = p.x + dr[d];
								int nc = p.y + dc[d];
								if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] == 0)
									continue;
								visit[nr][nc] = true;
								queue.add(new Point(nr, nc));
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
}
