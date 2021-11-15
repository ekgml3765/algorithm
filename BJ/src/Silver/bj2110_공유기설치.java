package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2110_공유기설치 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int arr [] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(arr);
		int start = 1;
		int end = arr[N-1]-arr[0];
		int ans = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			int node = arr[0];
			int cnt = 1;
			for (int i = 1; i < arr.length; i++) {
				int d = arr[i] - node;
				if(mid <= d) {
					cnt++;
					node = arr[i];
				}
			}
			if(cnt < C) {
				end = mid-1;
			}else {
				ans = mid;
				start = mid+1;
			}
		}
		System.out.println(ans);
	}
}
