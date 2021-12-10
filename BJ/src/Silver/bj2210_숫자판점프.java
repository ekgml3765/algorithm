package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj2210_숫자판점프 {
	static String map[][];
	static boolean visit[][];
	static HashSet<String> set = new HashSet<>();
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new String[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = st.nextToken();
			}		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, map[i][j]);
			}
		}
		System.out.println(set.size());
	}
	static int cnt = 0;
	private static void dfs(int r, int c, int depth, String s ) {
		if(depth == 5) {
			set.add(s);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5)
				continue;
			dfs(nr, nc, depth+1, s + map[nr][nc]);
		}
		
	}
}
