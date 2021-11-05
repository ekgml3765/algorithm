package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1743_음식물피하기 {
	static int N, M, K, map[][], ans = 0, cnt = 0;
	static boolean visit[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < K ; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = 1;
		}
		visit = new boolean[N][M];
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					visit[i][j] = true;
					cnt = 1;
					dfs(i, j);
					ans = Math.max(ans, cnt);
				}
			}
		}
		System.out.println(ans);
	}
	private static void dfs(int i, int j) {
		for(int d = 0; d < 4; d ++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] == 0)
				continue;
			visit[nr][nc] = true;
			dfs(nr, nc);
			cnt++;
		}
		
	}
}
