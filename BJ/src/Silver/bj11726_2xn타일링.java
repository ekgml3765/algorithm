package Silver;

import java.util.Scanner;

public class bj11726_2xn타일링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[] = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < 1001; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		System.out.println(dp[N]);
	}
}
