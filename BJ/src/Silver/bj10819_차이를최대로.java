package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10819_차이를최대로 {

	static int N, arr[], sel[], ans = 0;
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sel = new int [N];
		check = new boolean[N];
		perm(0);
		System.out.println(ans);
	}
	private static void perm(int idx) {
		if(idx == N) {
			int sum = 0;
			for (int i = 0; i < arr.length-1; i++) {
				sum += Math.abs(sel[i] - sel[i+1]);
			}
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				sel[idx] = arr[i];
				perm(idx+1);
				check[i] = false;
			}
		}
		
	}
}
