package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14889_스타트와링크 {
	static int N, map[][], ans;
	static boolean check[];
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
		check = new boolean[N];
		comb(0, 0);
		System.out.println(ans);
	}
	private static void comb(int idx, int s_idx) {
		if(s_idx == N/2) {
			int start = 0;
			int link = 0;
			for (int i = 0; i < check.length; i++) {
				if(check[i]) {
					for (int j = 0; j < check.length; j++) {
						if(check[j])
							start += map[i][j];
					}
				}else {
					for (int j = 0; j < check.length; j++) {
						if(!check[j])
							link += map[i][j];
					}
				}
			}
			ans = Math.min(ans, Math.abs(start-link));
			return;
		}
		if(idx == N)
			return;
		check[idx] = true;
		comb(idx+1, s_idx+1);
		check[idx] = false;
		comb(idx+1, s_idx);
	}
}
