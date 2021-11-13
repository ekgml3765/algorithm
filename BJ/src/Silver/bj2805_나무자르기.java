package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj2805_나무자르기 {
	static int N, M;
	static Integer arr[], ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Integer[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		int start = 0;
		int end = arr[0]-1;
		while(start <= end) {
			int mid = (start+end)/2;
			if(check(mid)) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		System.out.println(ans);
	}
	private static boolean check(int num) {
		long len = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]-num <= 0 || len >= M ) {
				break;
			}
			len += (arr[i]-num);
		}
		if(len < M)
			return false;
		ans = Math.max(ans, num);
		return true;
	}
}
