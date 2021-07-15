package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj20057_마법사상어와토네이도 {

	static int N, map[][], current_r, current_c, ans;
	static int dr[] = { 0, 1, 0, -1 }; // 좌 하 우 상
	static int dc[] = { -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end for

		// 시작점
		current_r = N / 2;
		current_c = N / 2;

		ans = 0;

		int moveCnt_odd = 2; // 짝수
		int moveCnt_hol = 1; // 홀수
		out: while (true) {
			// 4방향으로 토네이도 이동
			for (int d = 0; d < 4; d++) {
				if (d == 0 || d == 1) { // 홀수번 이동
					moveTonado(current_r, current_c, d, moveCnt_hol);
				} else { // 짝수번 이동
					moveTonado(current_r, current_c, d, moveCnt_odd);
				}
				// 4방향에 대해서 <-일때 0, 0이면 종료
				if (current_r == 0 && current_c == 0)
					break out;
			}
			moveCnt_odd += 2;
			moveCnt_hol += 2;
		} // end while

		System.out.println(ans);
	}

	// 토네이도이동
	private static void moveTonado(int r, int c, int dir, int moveCnt) {

		// 해당 방향으로 moveCnt만큼 이동
		int nr = r;
		int nc = c;

		for (int i = 0; i < moveCnt; i++) {

			// 한칸 이동할 위치
			nr += dr[dir];
			nc += dc[dir];
			// 방향에 따라 모래 흩날리기
			moveMore(current_r, current_c, dir, nr, nc);
			// 현재위치 바꿔
			current_r = nr;
			current_c = nc;
			// moveCnt만큼 이동하다가 0,0이면 종료
			if (nr == 0 && nc == 0) {
				current_r = 0;
				current_c = 0;
				return;
			}
		}

	}

	// 해당방향으로 모래 흩날리기
	private static void moveMore(int r, int c, int dir, int nnr, int nnc) {

		// r,c가 현재 위치고, nnr, nnc는 모래위치
		// 1,7,2,10,5,a
		// 좌,우
		int lr_dr[] = { -1, 1, -1, 1, -2, 2, -1, 1, 0, 0 };
		int left_dc[] = { 0, 0, -1, -1, -1, -1, -2, -2, -3, -2 };
		int right_dc[] = { 0, 0, 1, 1, 1, 1, 2, 2, 3, 2 };
		// 위, 아래
		int ud_dc[] = { -1, 1, -1, 1, -2, 2, -1, 1, 0, 0 };
		int down_dr[] = { 0, 0, 1, 1, 1, 1, 2, 2, 3, 2 };
		int up_dr[] = { 0, 0, -1, -1, -1, -1, -2, -2, -3, -2 };

		int dr[] = new int[10];
		int dc[] = new int[10];
		switch (dir) {
		case 0: { // 왼
			dr = lr_dr;
			dc = left_dc;
			break;
		}
		case 1: {// 아래
			dr = down_dr;
			dc = ud_dc;
			break;
		}
		case 2: {// 오
			dr = lr_dr;
			dc = right_dc;
			break;
		}
		case 3: {// 위
			dr = up_dr;
			dc = ud_dc;
			break;
		}
		}

		// 모래
		int more = map[nnr][nnc];
		int a = more;
		for (int d = 0; d < 10; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			int percent = 0;
			// 모래에 대해서 퍼센트 계산
			// 1
			if (d == 0 || d == 1) {
				percent = (int) (more * 0.01);
				a -= percent;
			}
			// 7
			if (d == 2 || d == 3) {
				percent = (int) (more * 0.07);
				a -= percent;
			}
			// 2
			if (d == 4 || d == 5) {
				percent = (int) (more * 0.02);
				a -= percent;
			}
			// 10
			if (d == 6 || d == 7) {
				percent = (int) (more * 0.1);
				a -= percent;
			}
			// 5
			if (d == 8) {
				percent = (int) (more * 0.05);
				a -= percent;
			}
			// a
			if (d == 9) {
				percent = a;
			}

			// 이게 만약 범위밖이라면 ans에 더해.
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				ans += percent;
				continue;
			}
			// 범위 안이면 기존 모래값에 더해
			map[nr][nc] = map[nr][nc] + percent;
		}

		// 모래가있던 위치는 0으로 초기화
		map[nnr][nnc] = 0;
	}
}
