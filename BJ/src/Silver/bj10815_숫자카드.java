package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10815_숫자카드 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			int ans = 0;
			int num = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = arr.length-1;
			int mid = 0;
			while(start<=end) {
				mid = (start+end) / 2;
				if(arr[mid] == num) {
					ans = 1;
					break;
				}
				if(arr[mid] < num) {
					start = mid+1;
				}
				if(arr[mid] > num) {
					end = mid-1;
				}
			}
			sb.append(ans + " ");
		}
		System.out.println(sb.toString());
	}
}
