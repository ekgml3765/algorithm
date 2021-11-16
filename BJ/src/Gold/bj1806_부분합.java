package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int len = Integer.MAX_VALUE;
		while(start < N) {
			if(sum > S || end == N) {
				sum -= arr[start++];
			}else {
				sum += arr[end++];
			}
			//그 합이 S이상일 때 길이
			if(sum >= S) {
				len = Math.min(len, end-start);
			}
		}
		System.out.println((len == Integer.MAX_VALUE)? 0 : len);
	}
}
