package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14620_꽃길 {

	static int N, map[][], ans;
	static int sel[];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sel = new int[3];
		comb(1,0);
		System.out.println(ans);
	}
	private static void comb(int idx, int s_idx) {
		if(s_idx == 3) {
			chech();
			return;
		}
		if(idx > (N-2)*(N-2))
			return;
		sel[s_idx] = idx;
		comb(idx+1, s_idx+1);
		comb(idx+1, s_idx);
	}
	private static void chech() {
		boolean visit[][] = new boolean [N][N];
		boolean flag = true;
		int r, c;
		int sum = 0;
		out:for (int i = 0; i < sel.length; i++) {
			if(sel[i]%(N-2) == 0) {
				r = sel[i]/(N-2);
				c = N-2;
			}else {
				r = (sel[i]/(N-2))+1;
				c = sel[i]%(N-2);
			}
			if(visit[r][c]) {
				flag = false;
				break;
			}
			visit[r][c] = true;
			sum += map[r][c];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc]) {
					flag = false;
					break out;
				}
				visit[nr][nc] = true;
				sum += map[nr][nc];
			}
		}
		if(flag)
			ans = Math.min(ans, sum);
	}
}
