package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20057_마법사상어와토네이도_3회독 {
	static int N, map[][], ans = 0, r, c, dir;
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { -1, 0, 1, 0 };
	static boolean flag = false;
	static double arr[] = { 0.01, 0.01, 0.07, 0.07, 0.02, 0.02, 0.1, 0.1, 0.05, 0 };
	static int ddr[] = { -1, 1, -1, 1, -2, 2, -1, 1, 0, 0 };
	static int ddc[] = { 0, 0, -1, -1, -1, -1, -2, -2, -3, -2 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int even = 1;
		int odd = 1;
		r = N / 2;
		c = N / 2;
		dir = 0;
		out: while (true) {
			if (dir % 2 == 0) {
				for (int j = 0; j < even; j++) {
					go();
					if (flag)
						break out;
				}
				even++;
			} else {
				for (int j = 0; j < odd; j++) {
					go();
				}
				odd++;
			}
			dir = (dir + 1) % 4;
		}
		System.out.println(ans);
	}

	private static void go() {
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		int y = map[nr][nc];
		if (dir % 2 == 0) {// 왼, 오
			int n = (dir == 2) ? -1 : 1;
			for (int d = 0; d < 10; d++) {
				int nnr = r + ddr[d];
				int nnc = c + (ddc[d] * n);
				int m = (int) (map[nr][nc] * arr[d]);
				y -= m;
				if (d == 9)
					m = y;
				if (nnr < 0 || nnc < 0 || nnr >= N || nnc >= N) {
					ans += m;
					continue;
				}
				map[nnr][nnc] += m;

			}
		} else {// 위, 아
			int n = (dir == 1) ? -1 : 1;
			for (int d = 0; d < 10; d++) {
				int nnr = r + (ddc[d] * n);
				int nnc = c + ddr[d];
				int m = (int) (map[nr][nc] * arr[d]);
				y -= m;
				if (d == 9)
					m = y;
				if (nnr < 0 || nnc < 0 || nnr >= N || nnc >= N) {
					ans += m;
					continue;
				}
				map[nnr][nnc] += m;
			}
		}

		map[nr][nc] = 0;
		r = nr;
		c = nc;
		if (r == 0 && c == 0)
			flag = true;
	}
}