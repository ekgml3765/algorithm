package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj2467_용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = N-1;
		int ans[] = new int[2];
		int min = Integer.MAX_VALUE;
		while(start < end) {
			int sum = arr[start] + arr[end];
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				ans[0] = arr[start];
				ans[1] = arr[end];
				if(min == 0)
					break;
			}
			if(sum < 0)
				start++;
			else {
				end--;
			}		
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
}
