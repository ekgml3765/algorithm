package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int coin[] = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		int ans = 0;
		for (int i = N-1; i >= 0; i--) {
			if(K >= coin[i]) {
				int quo = K / coin[i];
				ans+=quo;
				K = K - (coin[i]* quo);
			}
			if(K==0)
				break;
		}
		System.out.println(ans);
	}
}
