package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj13023_ABCDE {
	static List<Integer> list[];
	static boolean visit[];
	static int N, M, ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		for(int i = 0 ; i < N; i++)
			list[i] = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		visit = new boolean[N];
		for(int i = 0 ; i < N; i++) {
			visit[i] = true;
			dfs(i, 0);
			visit[i] = false;
		}
		System.out.println(ans);
	}
	public static void dfs(int num, int depth) {
		if(depth == 4) {
			ans = 1;
			System.out.println(ans);
			System.exit(0);
			return;
		}
		for (Integer next : list[num]) {
			if(!visit[next]) {
				visit[next] = true;
				dfs(next, depth+1);
				visit[next] = false;
			}
		}
	}
}
