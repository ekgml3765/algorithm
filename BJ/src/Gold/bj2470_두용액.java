package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj2470_두용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		long arr[] = new long[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = N - 1;
		long sum = 0;
		long num = Integer.MAX_VALUE;
		long ans1 = 0;
		long ans2 = 0;
		while (start < end) {
			sum = arr[start] + arr[end];
			if (Math.abs(0 - sum) < num) {
				num = Math.abs(0 - sum);
				ans1 = (arr[start] < arr[end]) ? arr[start] : arr[end];
				ans2 = (arr[start] > arr[end]) ? arr[start] : arr[end];
				if (sum == 0)
					break;
			}
			if (sum < 0) {
				start++;
			} else {
				end--;
			}

		}
		System.out.println(ans1 + " " + ans2);
	}
}
