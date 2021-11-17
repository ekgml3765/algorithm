package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10025_게으른백곰 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[1000001];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x] = g;
		}
		int len = 2 * K +1;
		int max = 0;
		int start = 0;
		int end = 0;
		int sum = 0;
		while(start < arr.length) {
			if(end - start + 1 <= len && end < arr.length) {
				sum += arr[end++];
				max = Math.max(max, sum);
			}else {
				sum -= arr[start++];
			}
		}
		System.out.println(max);
	}
}
