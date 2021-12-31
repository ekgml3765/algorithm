package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj1405_미친로봇 {
	static int N;
	static double ans = 0;
	static double arr[];
	static boolean visit[][];
	static int dr[] = {0, 0, 1, -1};
	static int dc[] = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new double[4];
		visit = new boolean [30][30];
		int dir = 0;
		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) * 0.01;
		}
		visit[15][15] = true;
		dfs(0, 15, 15, 1);
		System.out.println(ans);
	}
	
	private static void dfs(int idx, int i, int j, double t) {
		if(idx == N){
			ans += t;
			return;
		}
		for (int d = 0; d < 4; d++) {
			if(arr[d] == 0)
				continue;
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nc < 0 || nr >= 30 || nc >= 30)
				continue;
			if(visit[nr][nc])
				continue;
			visit[nr][nc] = true;
			dfs(idx+1, nr, nc, t * arr[d]);
			visit[nr][nc] = false;
		}
		
	}
}
