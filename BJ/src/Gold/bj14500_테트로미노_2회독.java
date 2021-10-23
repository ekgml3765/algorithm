package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14500_테트로미노_2회독 {
	static int N, M, map[][], max = 0;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static boolean visit[][];
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
		}//입력 끝
		visit = new boolean[N][M];
		//모든 맵에 대해서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
				dfs2(i, j);
			}
		}
		System.out.println(max);
	}
	private static void dfs2(int i, int j) {
		out:for (int d = 0; d < 4; d++) {
			int sum = map[i][j];
			int arr[] = new int[3];
			arr[0] = d;
			arr[1] = (d+1) % 4;
			arr[2] = (d-1 < 0) ? 3 : d-1;
			for (int k = 0; k < 3; k++) {
				int nr = i + dr[arr[k]];
				int nc = j + dc[arr[k]];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue out;
				sum+= map[nr][nc];
			}
			max = Math.max(max, sum);
		}
	}
	private static void dfs(int i, int j, int idx, int sum) {
		if(idx == 4) {
			max = Math.max(max, sum);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc])
				continue;
			visit[nr][nc] = true;
			dfs(nr, nc, idx+1, sum+map[nr][nc]);
			visit[nr][nc] = false;
		}
		
	}
}
