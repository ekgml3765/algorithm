package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15661_링크와스타트 {
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
		powerSet(0);
		System.out.println(ans);
	}
	static public void powerSet(int idx) {
		if(idx == N) {
			int start = 0;
			int link = 0;
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					for (int j = 0; j < sel.length; j++) {
						if(sel[j])
							start+= map[i][j];
					}
				}
				else {
					for (int j = 0; j < sel.length; j++) {
						if(!sel[j])
							link+= map[i][j];
					}
				}
			}
			if(start > 0 && link > 0)
				ans = Math.min(ans, Math.abs(start-link));
			return;
		}
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);
	}
}
