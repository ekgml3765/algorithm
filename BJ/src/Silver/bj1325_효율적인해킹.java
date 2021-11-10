package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj1325_효율적인해킹 {
	static int N, M;
	static List<Integer> list[];
	static boolean visit[];
	static int ans[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		ans = new int[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		for(int i = 1; i <= N; i++ ) {
			visit = new boolean[N+1];
			dfs(i);
		}
		int max = 0;
		for (int i = 1; i < ans.length; i++) {
			max = Math.max(max, ans[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < ans.length; i++) {
			if(ans[i] == max)
				sb.append(i + " ");
		}
		System.out.println(sb);
	}
	private static void dfs(int num) {
		visit[num] = true;
		for (int next : list[num]) {
			if(!visit[next]) {
				ans[next]++;
				dfs(next);
			}
		}		
	}
}
