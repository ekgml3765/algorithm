package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20057_마법사상어와토네이도_2회독 {
	static int N, map[][], ans = 0;
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { -1, 0, 1, 0 };
	static int lr[][] = { { -1, 1 }, { -1, 1, -2, 2 }, { -1, 1, 0 }, { 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		// 토네이도 이동
		int r = N / 2;
		int c = N / 2;
		int odd = 1;
		int even = 2;
		out: while (true) {
			for (int d = 0; d < 4; d++) {
				int max = 0;
				if (d < 2)
					max = odd;
				else
					max = even;
				for (int i = 0; i < max; i++) {
					if (r == 0 && c == 0)
						break out;
					go(r, c, d);
					r += dr[d];
					c += dc[d];
				}
			}
			odd += 2;
			even += 2;
		}
		System.out.println(ans);
	}

	// 흩날리기
	private static void go(int r, int c, int d) {
		int y = map[r + dr[d]][c + dc[d]];
		int a = y - (2 * ((int) (y * 0.01) + (int) (y * 0.07) + (int) (y * 0.02) + (int) (y * 0.1)) + (int) (y * 0.05));
		map[r + dr[d]][c + dc[d]] = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < lr[i].length; j++) {
				int nr = 0, nc = 0;
				if (d == 0 || d == 2) {
					nr = r + lr[i][j];
					nc = (d == 0) ? c - i : c + i;
				}
				else {
					nr = (d == 1) ? r + i : r - i;
					nc = c + lr[i][j];
				}
				int num = 0;
				switch (i) {
				case 0: {
					num = (int) (0.01 * y);
					break;
				}
				case 1: {
					if (j < 2)
						num = (int) (0.07 * y);
					else
						num = (int) (0.02 * y);
					break;
				}
				case 2: {
					if (j < 2)
						num = (int) (0.1 * y);
					else
						num = a;
					break;
				}
				case 3: {
					num = (int) (0.05 * y);
					break;
				}
				}
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					ans += num;
					continue;
				}
				map[nr][nc] += num;
			}
		}

	}
}
