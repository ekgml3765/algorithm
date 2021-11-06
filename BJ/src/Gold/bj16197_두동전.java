package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj16197_두동전 {
	static int N, M, ans = 11;
	static char map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		List<Point> coin = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'o') {
					coin.add(new Point(i, j));
					map[i][j] = '.';
				}
			}
		}
		dfs(0, coin.get(0).x, coin.get(0).y, coin.get(1).x, coin.get(1).y);
		System.out.println((ans == 11) ? -1 : ans);
	}

	private static void dfs(int idx, int r1, int c1, int r2, int c2) {

		if (idx == 10)
			return;

		for (int d = 0; d < 4; d++) {
			int nr1 = r1 + dr[d];
			int nc1 = c1 + dc[d];
			int nr2 = r2 + dr[d];
			int nc2 = c2 + dc[d];
			// 범위밖 체크
			boolean flag1 = check(nr1, nc1);
			boolean flag2 = check(nr2, nc2);
			if (flag1 && flag2)
				continue;
			if (flag1 || flag2) {
				ans = Math.min(ans, idx + 1);
				continue;
			}
			// 벽 체크
			if (map[nr1][nc1] == '#') {
				nr1 = r1;
				nc1 = c1;
			}
			if (map[nr2][nc2] == '#') {
				nr2 = r2;
				nc2 = c2;
			}
			dfs(idx + 1, nr1, nc1, nr2, nc2);
		}
	}

	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M)
			return true;
		return false;
	}
}
