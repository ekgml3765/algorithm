package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17070_파이프옮기기1 {

	static int N, map[][];
	static int ans = 0;
	static int dir[][][] = { // d, d방향이 갈 수 있는 곳, dr/dc/다음방향
			{ { 0, 1, 0 }, { 1, 1, 2 } }, 
			{ { 1, 0, 1 }, { 1, 1, 2 } }, 
			{ { 0, 1, 0 }, { 1, 0, 1 }, { 1, 1, 2 } } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝
		dfs(0, 1, 0);
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int curDir) {
		
		if(r == N-1 && c == N-1 && map[N-1][N-1] != 1) {
			ans++;
			return;
		}
		
		for (int i = 0; i < dir[curDir].length; i++) {
			int nr =  r + dir[curDir][i][0];
			int nc =  c + dir[curDir][i][1];
			int nextDir = dir[curDir][i][2];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1)
				continue;
			//대각선 처리, 위 아래 체크
			if(nextDir == 2) {
				if(nr-1 < 0 || nc-1 <0)
					continue;
				if(map[nr-1][nc] == 1 || map[nr][nc-1] == 1)
					continue;
			}
			dfs(nr, nc, nextDir);
		}
		
		
	}
}
