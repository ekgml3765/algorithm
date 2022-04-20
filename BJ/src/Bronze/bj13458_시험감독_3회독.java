package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13458_시험감독_3회독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int A[] = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long ans = 0;
		for (int i = 0; i < A.length; i++) {
			ans++;
			int n = A[i] - B;
			if (n <= 0)
				continue;
			ans += (n % C == 0) ? n / C : n / C + 1;

		}
		System.out.println(ans);
	}
}
