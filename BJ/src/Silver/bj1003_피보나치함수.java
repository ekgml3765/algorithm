package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1003_피보나치함수 {
	static int dp[] = new int[100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		dp[1] = 1;
		for(int tc = 1; tc <= T ; tc++) {
			int N = Integer.parseInt(in.readLine());
			fibo(N);
			if(N == 0)
				System.out.println("1" + " " + "0");
			else
				System.out.println(dp[N-1] + " " + dp[N]);
		}
	}
	private static int fibo(int n) {
		if(n <= 1) {
			return n;
		}
		if(dp[n] != 0)
			return dp[n];
		return dp[n] = fibo(n-1) + fibo(n-2);
		
	}
}
