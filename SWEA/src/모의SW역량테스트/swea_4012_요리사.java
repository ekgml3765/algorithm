package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_4012_요리사 {
	static int map[][], ans, N;
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			check = new boolean[N];
			comb(0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void comb(int idx, int s_idx) {
		if (s_idx == N / 2) {
			int A = 0;
			int B = 0;
			for (int i = 0; i < N; i++) {
				if(check[i]) {
					for (int j = 0; j < N; j++) {
						if(check[j])
							A += map[i][j];
					}
				}else {
					for (int j = 0; j < N; j++) {
						if(!check[j])
							B += map[i][j];
					}
				}
			}
			int dif = Math.abs(A-B);
			ans = Math.min(ans, dif);
			return;
		}
		if (idx == N)
			return;
		check[idx] = true;
		comb(idx + 1, s_idx + 1);
		check[idx] = false;
		comb(idx + 1, s_idx);
	}
}
