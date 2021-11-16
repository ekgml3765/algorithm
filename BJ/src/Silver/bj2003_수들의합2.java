package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2003_수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int start = 0;
		int end = 0;
		int sum = 0;
		while(start < N ) {
			//부분합이 M 보다 크면 start++
			if(sum > M || end == N)
				sum -= arr[start++];
			//부분합이 M보다 작거나 같으면 end++;
			else {
				sum += arr[end++];
			}
			//부분합이 M이면 ans++;
			if(sum == M)
				ans++;
		}
		System.out.println(ans);
	}
}
