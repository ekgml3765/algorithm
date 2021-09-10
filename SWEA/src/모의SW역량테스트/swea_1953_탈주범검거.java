package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953_탈주범검거 {
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };

	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static String[] t = {"","0123", "02", "13", "03", "23", "12", "01"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 1;
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int map[][] = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝

			Queue<Point> queue = new LinkedList<Point>();
			boolean visit[][] = new boolean[N][M];
			queue.add(new Point(R, C, 1));
			visit[R][C] = true;
			while (!queue.isEmpty()) {
				Point p = queue.poll();
				if (p.cnt == L)
					break;	
				int curTunnel = map[p.x][p.y];
				for (int d = 0; d < 4; d++) {
					int nr = p.x + dr[d];
					int nc = p.y + dc[d];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] == 0)
						continue;
					int nextTunnel = map[nr][nc];
					String opDir = Integer.toString((d + 2) % 4);
					if(!t[nextTunnel].contains(opDir))
						continue;
					if(curTunnel == 2 && d%2 != 0)
						continue;
					if(curTunnel == 3 && d%2 == 0)
						continue;
					if(curTunnel == 4 && d%3 != 0)
						continue;
					if(curTunnel == 5 && d < 2)
						continue;
					if(curTunnel == 6 && d%3 == 0)
						continue;
					if(curTunnel == 7 && d > 1)
						continue;		
					visit[nr][nc] = true;
					queue.add(new Point(nr, nc, p.cnt + 1));
					ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
