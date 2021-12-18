package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj13565_침투 {
	static int N, M, map[][];
	static boolean visit[][];
	static String ans = "NO";
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int j = 0; j < M; j++) {
			visit = new boolean[N][M];
			visit[0][j] = true;
			if(dfs(0, j))
				break;
		}
		System.out.println(ans);
	}
	private static boolean dfs(int r, int c) {
		if(r == N-1) {
			ans = "YES";
			return true;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] == 1)
				continue;
			visit[nr][nc] = true;
			if(dfs(nr, nc))
				return true;
		}
		return false;
		
	}
}
