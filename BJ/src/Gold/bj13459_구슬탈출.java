package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13459_구슬탈출 {

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int N, M;
	static char[][] map;

	static class Marble {
		int r, c;

		public Marble(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];
		Marble red = null, blue = null;
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					red = new Marble(i, j);
					map[i][j] = '.';
				}
				if (map[i][j] == 'B') {
					blue = new Marble(i, j);
					map[i][j] = '.';
				}
			}
		}
		if (dfs(0, -1, red, blue))
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static boolean dfs(int cnt, int previos, Marble red, Marble blue) {
		if (cnt == 10) {
			return false;
		}

		for (int d = 0; d < 4; d++) {
			if (d == previos)
				continue;
			Marble copyRed = move(d, red.r, red.c);
			Marble copyBlue = move(d, blue.r, blue.c);
			if (map[copyRed.r][copyRed.c] == 'O' && map[copyBlue.r][copyBlue.c] != 'O') { // 레드만 구멍으로 갈 경우
				return true;
			}
			if (map[copyBlue.r][copyBlue.c] == 'O') {
				continue;
			}
			// 둘다 안 빠졌을 경우
			if (copyRed.r == copyBlue.r && copyRed.c == copyBlue.c) {// 같은 위치일 경우 위치 조정해야함
				if (d == 0) { // 상
					if (red.r < blue.r) {
						copyBlue.r += 1;
					} else {
						copyRed.r += 1;
					}
				} else if (d == 1) { // 하
					if (red.r > blue.r) {
						copyBlue.r -= 1;
					} else {
						copyRed.r -= 1;
					}
				} else if (d == 2) { // 좌
					if (red.c < blue.c) {
						copyBlue.c += 1;
					} else {
						copyRed.c += 1;
					}
				} else if (d == 3) { // 우
					if (red.c > blue.c) {
						copyBlue.c -= 1;
					} else {
						copyRed.c -= 1;
					}
				}
			}
			
			if (dfs(cnt + 1, d, copyRed, copyBlue)) {
				return true;
			}
		}
		return false;

	}

	private static Marble move(int d, int r, int c) {
		Marble m = null;
		int nr = r;
		int nc = c;
		while (true) {
			nr = r + dr[d];
			nc = c + dc[d];
			if (map[nr][nc] == 'O') {
				m = new Marble(nr, nc);
				break;
			}
			if (map[nr][nc] == '#') {
				m = new Marble(r, c);
				break;
			}
			r = nr;
			c = nc;
		}
		return m;
	}

}
