package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj15684_사다리조작 {

	static int N, M, H;
	static int map[][];
	static int sadari[];
	static int R;
	static int sel[];
	static boolean flag;
	static List<Point> possible;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로선 갯수
		M = Integer.parseInt(st.nextToken()); // 놓여진 가로행
		H = Integer.parseInt(st.nextToken()); // 놓을 수 있는 가로선 행

		map = new int[H + 1][N + 1];
		sadari = new int[N + 1]; // 세로선
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int to = from + 1;
			map[r][from] = to;
			map[r][to] = from;
		}

		possible = new ArrayList<Point>();
		// 가로선 놓을 수 있는 r,c찾아
		for (int j = 1; j < N; j++) {
			for (int i = 1; i <= H; i++) { // 모든 가로선을 다 봐
				if (map[i][j] == 0) {
					// 오른쪽만 보고 오른쪽에 값이 있으면 못놔
					if (map[i][j + 1] == 0) {// 가로선 할 수 있어
						possible.add(new Point(i, j));
					}

				}
			}
		}
		goSadari(map);
		flag = check();
		if (flag) {
			System.out.println(0);
			return;
		} else {// 가로선 놔봐야해

			for (int i = 1; i <= 3; i++) {
				R = i;
				sel = new int[R];
				comb(0, 0);
				if (flag) {
					System.out.println(i);
					return;
				}
			}
			System.out.println(-1);
		}
	}

	// 조합 뽑기
	private static void comb(int idx, int s_idx) {

		if (s_idx == R) {
			int newMap[][] = new int[H + 1][N + 1];
			for (int i = 0; i < H + 1; i++) {
				for (int j = 0; j < N + 1; j++) {
					newMap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < sel.length; i++) {
				int r = possible.get(sel[i]).x; // 행
				int from = possible.get(sel[i]).y;
				int to = from + 1;
				if (newMap[r][from] != 0 || newMap[r][to] != 0) {// 이미 놓여졌다?
					return;
				} else {// 그게 아니라면 사다리 놔바
					newMap[r][from] = to;
					newMap[r][to] = from;
				}
			}		
			// 가로선 다 놓고 사다리 타봐
			goSadari(newMap);
			if (check()) {
				flag = true;
				return;
			}
			return;
		}
		if (idx == possible.size()) {
			return;
		}
		sel[s_idx] = idx;
		comb(idx + 1, s_idx + 1);
		comb(idx + 1, s_idx);
	}

	// 사다리 타기
	private static void goSadari(int map[][]) {

		for (int c = 1; c < sadari.length; c++) {

			int nr = 1;
			int nc = c;
			while (true) {
				if (nr == H + 1) { // 행이 놓을 수 있는 H개 넘으면
					sadari[c] = nc;
					break;
				}
				if (map[nr][nc] == 0) {
					nr++;
					continue;
				}
				if (map[nr][nc] != 0) {// 가로선이 있다
					int num = map[nr][nc];
					nc = num;
					nr++;
				}
			}
		}

	}

	// 자기자신으로 오는지 검사
	static private boolean check() {
		for (int i = 1; i < sadari.length; i++) {
			if (i != sadari[i])
				return false;
		}
		return true;
	}
}
