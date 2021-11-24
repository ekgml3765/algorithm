package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1476_날짜계산 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int E = Integer.parseInt(st.nextToken()) % 15;
		int S = Integer.parseInt(st.nextToken()) % 28;
		int M = Integer.parseInt(st.nextToken()) % 19;
		int ans = 1;
		while(true) {
			if(ans%15 == E && ans%28 == S && ans %19 == M)
				break;
			ans++;
		}
		System.out.println(ans);
	}
}
