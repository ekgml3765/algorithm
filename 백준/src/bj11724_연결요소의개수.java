

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11724_연결요소의개수 {

	static ArrayList<Integer> arrList [];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken()); //정점의 개수
		int m = Integer.parseInt(st.nextToken()); //간선정보
		
		arrList = new ArrayList [n+1];
		visit = new boolean [n+1];
		int ans = 0;
		for (int i = 1; i < n+1; i++) {
			arrList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arrList[a].add(b);
			arrList[b].add(a);
		}
		
		for (int i = 1; i <= n; i++) {
			if(!visit[i]) {
				dfs(i);
				ans++;
			}
		}
		
		System.out.println(ans);
		
		
	}

	private static void dfs(int v) {
		
		visit[v] = true;
		for (int i : arrList[v]) {
			if(!visit[i]) {
				dfs(i);
			}
		}
		
	}
}
