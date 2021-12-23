package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17484_진우의달여행 {
	static int Dir[][] = {{1, -1}, {1, 0}, {1, 1}};
	static int N, M, map[][], ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int j = 0; j < M; j++) {
			dfs(0, j, map[0][j], -1);
		}
		System.out.println(ans);
	}
	private static void dfs(int i, int j, int sum, int dir) {
		if(i == N-1) {
			ans = Math.min(sum, ans);
			return;
		}	
		for (int d = 0; d < 3; d++) {
			if(d == dir)
				continue;
			int nr = i + Dir[d][0];
			int nc = j + Dir[d][1];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			dfs(nr, nc, sum+map[nr][nc], d);
		}
	}
}
