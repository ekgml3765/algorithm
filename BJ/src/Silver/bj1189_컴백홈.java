package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1189_컴백홈 {

	static int R, C, K;
	static char map[][];
	static int ans = 0;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = in.readLine();
			map[i] = s.toCharArray();
		}
		visit[R - 1][0] = true;
		dfs(R - 1, 0, 1);
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int cnt) {
		if (r == 0 && c == C - 1) {
			if (cnt == K)
				ans++;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < R && nc < C && !visit[nr][nc] && map[nr][nc] != 'T') {
				visit[nr][nc] = true;
				dfs(nr, nc, cnt + 1);
				visit[nr][nc] = false;
			}
		}

	}
}
