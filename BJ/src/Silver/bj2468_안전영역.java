package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2468_안전영역 {

	static int N, map[][];
	static boolean visit[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		int max = 0;
		int min = 100;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}//end for
		int ans = 0;
		for (int num = min; num <= max; num++) { // 덩어리 1개도 갯수 세야함
			int cnt = 0;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j] && map[i][j] >= num ) {
						cnt++;
						visit[i][j] = true;
						dfs(i, j, num);
					}
				}
			} //end for
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};	
	private static void dfs(int r, int c, int num) {
	
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if( nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] < num)
				continue;
			visit[nr][nc] = true;
			dfs(nr, nc, num);
		}
		
	}
}
