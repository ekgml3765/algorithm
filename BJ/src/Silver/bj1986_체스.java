package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1986_체스 {
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int ddr[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int ddc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		int check[][] = new int[n][m];
		int ans = 0;
		List<Point> qList = new ArrayList<>();
		List<Point> kList = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(in.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int r = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken()) - 1;
				map[r][c] = i;
				check[r][c] = i;
				if (i == 1)
					qList.add(new Point(r, c));
				if (i == 2)
					kList.add(new Point(r, c));
			}
		}
		for (Point p : qList) {
			for (int d = 0; d < 8; d++) {
				int nr = p.x;
				int nc = p.y;
				while(true) {
					nr += dr[d];
					nc += dc[d];
					if(nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] != 0)
						break;
					check[nr][nc] = 1;
				}
			}
		}
		
		for (Point p : kList) {
			for (int d = 0; d < 8; d++) {
				int nr = p.x + ddr[d];
				int nc = p.y + ddc[d];
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] != 0)
					continue;
				check[nr][nc] = 2;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check[i][j] == 0)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
