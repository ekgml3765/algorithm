package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2512_예산 {
	static int N, M, arr[];
	static int ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		arr = new int[N];
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(in.readLine());
		Arrays.sort(arr);
		int start = M / arr.length;
		int end = arr[arr.length-1];
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
	static boolean check(int num) {
		int limit = M;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < num) {
				limit-= arr[i];
			}		
			else {
				limit-=num;
			}
			if(limit < 0)
				return false;
		}
		ans = Math.max(num, ans);
		return true;
	}
}
