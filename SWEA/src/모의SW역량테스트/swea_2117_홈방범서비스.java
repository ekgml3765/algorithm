package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2117_홈방범서비스 {
	static int ansCnt, map[][], N, M, homeCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ansCnt = 0;
			homeCnt = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int K = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						homeCnt++;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					solve(i, j);
				}
			}
			System.out.println("#" + tc + " " + ansCnt);
		}
	}

	private static void solve(int i, int j) {
		int cnt = 0;
		int k = 1;
		while(k < N+2) {
			// 위
			int C = j;
			int hol = 1;
			for (int r = i - (k - 1); r <= i; r++) {
				for (int c = C; c < C + hol; c++) {
					if (r < 0 || c < 0 || r >= N || c >= N)
						continue;
					if (map[r][c] == 1)
						cnt++;
				}
				C--;
				hol += 2;
			}
			// 아래
			C += 2;
			hol -= 4;
			for (int r = i + 1; r < i + k; r++) {
				for (int c = C; c < C + hol; c++) {
					if (r < 0 || c < 0 || r >= N || c >= N)
						continue;
					if (map[r][c] == 1)
						cnt++;
				}
				C++;
				hol -= 2;
			}
			int money = (cnt * M) - (k * k + (k - 1) * (k - 1));
			if (money >= 0) { //손해보지 않는다고 했으므로 0도 가능
				ansCnt = Math.max(cnt, ansCnt);
			}
			k++;
			cnt = 0;
		}
	}
}
