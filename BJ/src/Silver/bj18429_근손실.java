package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18429_근손실 {
	static int N, K, arr[], ans = 0;
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		check = new boolean[N];
		dfs(0, 500);
		System.out.println(ans);
	}
	private static void dfs(int day, int sum) {
		if(day == N) {
			ans++;
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!check[i] && sum - K + arr[i] >= 500) {
				check[i] = true;
				dfs(day+1, sum -K + arr[i]);
				check[i] = false;
			}
		}
	}
}
