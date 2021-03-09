package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14503_로봇청소기 {

	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int clean_cnt = 0;
		// 맨 처음칸은 청소하고 들어가
		visit[r][c] = true;
		boolean isWork = true;
		clean_cnt++;
		while (isWork) {

			// 2번 시작
			for (int i = 0; i < 4; i++) {
				// 왼쪽으로 방향 바꿈
				d -= 1;
				if (d < 0)
					d = 3;
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!visit[nr][nc] && map[nr][nc] != 1) {
					r = nr;
					c = nc;
					visit[nr][nc] = true;
					clean_cnt++;
					map[nr][nc] = 2;
					break;
				}

				if (i == 3) {
					// 후진방향
					int nnr = r - dr[d];
					int nnc = c - dc[d];
					if (map[nnr][nnc] != 1) {// 후진가능하다면 후진
						r = nnr;
						c = nnc;
					} else {// 한칸 후진할 수 없을때는 작동 종료
						isWork = false;
					}
				}
			}
		}
		
		System.out.println(clean_cnt);

	}
}
