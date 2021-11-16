package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj3273_두수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(in.readLine());
		int ans = 0;
		
		int start = 0;
		int end = arr.length-1;
		int sum = 0;
		while(start < end) {
			sum = arr[start] + arr[end];
			if(sum >= m) {
				end--;
			}else {
				start++;
			}
			if(sum == m)
				ans++;
		}
		System.out.println(ans);
	}
}
