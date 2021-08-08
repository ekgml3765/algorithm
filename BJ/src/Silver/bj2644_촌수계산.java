package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2644_촌수계산 {

	static int N, map[][], endR, endC, ans;
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visit = new boolean[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		endR = Integer.parseInt(st.nextToken())-1;
		endC = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
			map[b][a] = 1;
		}//입력 끝
		ans = Integer.MAX_VALUE;
		visit[endR] = true;
		dfs(endR, 0);
		System.out.println(ans = (ans==Integer.MAX_VALUE)? -1 : ans);
	}

	private static void dfs(int go, int cnt) {
		if(go == endC) {
			ans = Math.min(cnt, ans);
			return;
		}
		
		for (int j = 0; j < N; j++) {
			if(map[go][j] == 1 && !visit[j]) {
				visit[j] = true;
				dfs(j, cnt+1);
			}
		}
	}
}
