package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14889_스타트와링크_2회독 {

	static int N, map[][], ans = Integer.MAX_VALUE;
	static boolean sel[];
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
		sel = new boolean[N];
		comb(0, 0);
		System.out.println(ans);
	}
	private static void comb(int idx, int s_idx) {
		if(s_idx == N/2) {
			int s = 0, l = 0;
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					for (int j = 0; j < N; j++) {
						if(sel[j]) {
							s += map[i][j];
						}
					}
				}else {
					for (int j = 0; j < N; j++) {
						if(!sel[j]) {
							l += map[i][j];
						}
					}
				}
			}
			ans = Math.min(ans, Math.abs(s-l));
			return;
		}
		if(idx == N) 
			return;
		
		sel[idx] = true;
		comb(idx+1, s_idx+1);
		sel[idx] = false;
		comb(idx+1, s_idx);
		
	}
}
