package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1182_부분수열의합 {
	static int N, S, arr[], cnt = 0;
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		check = new boolean[N];
		dfs(0);
		System.out.println(cnt);
	}
	
	private static void dfs(int idx) {
		if(idx == N) {
			int sum = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if(check[i]) {
					sum += arr[i];
					flag = true;
				}
			}
			if(sum == S && flag) 
				cnt++;
			return;
		}
		check[idx] = true;
		dfs(idx+1);
		check[idx] = false;
		dfs(idx+1);
		
	}
}
