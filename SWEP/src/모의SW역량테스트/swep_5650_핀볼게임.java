package 모의SW역량테스트;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swep_5650_핀볼게임 {

	static int ans = 0, N;
	static int map[][];
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static List<Point>[] warm;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			List<Point> departList = new ArrayList<Point>();
			warm = new ArrayList[11];
			for (int i = 6; i <= 10; i++) {
				warm[i] = new ArrayList<>();
			}
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) {
						departList.add(new Point(i, j));
					}
					if (map[i][j] >= 6) {
						warm[map[i][j]].add(new Point(i, j));
					}
				}
			} // 입력끝
			for (Point point : departList) {
				for (int d = 0; d < 4; d++) {
					int cnt = go(point.x, point.y, d);
					ans = Math.max(ans, cnt);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static int go(int startR, int startC, int d) {
		int cnt = 0;
		boolean flag = false;
		int r = startR;
		int c = startC;
		while (true) {
			int nr = 0;
			int nc = 0;
			int num = map[r][c];
			// 블록
			if (1 <= num && num <= 5) {
				cnt++;
				switch (num) {
				case 1: {
					if (d == 0 || d == 3) {
						d = (d % 2 == 0) ? 2 - d : 4 - d;
					} else {
						d = (d == 1) ? 0 : 3;
					}
					break;
				}
				case 2: {
					if (d == 2 || d == 3) {
						d = (d % 2 == 0) ? 2 - d : 4 - d;
					} else {
						d = (d == 0) ? 3 : 2;
					}
					break;
				}
				case 3: {
					if (d == 1 || d == 2) {
						d = (d % 2 == 0) ? 2 - d : 4 - d;
					} else {
						d = (d == 0) ? 1 : 2;
					}
					break;
				}
				case 4: {
					if (d == 0 || d == 1) {
						d = (d % 2 == 0) ? 2 - d : 4 - d;
					} else {
						d = (d == 2) ? 1 : 0;
					}
					break;
				}
				case 5: {
					d = (d % 2 == 0) ? 2 - d : 4 - d;
					break;
				}
				}
			}
			nr = r + dr[d];
			nc = c + dc[d];
			// 벽
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				d = (d % 2 == 0) ? 2 - d : 4 - d;
				cnt++;
				nr = r;
				nc = c;
			}
			// 종료조건
			if (map[nr][nc] == -1 || (nr == startR && nc == startC)) {
				break;
			}
			if (map[nr][nc] >= 6) {// 웜홀
				int warmNum = map[nr][nc];
				for (int i = 0; i < 2; i++) {
					if (warm[warmNum].get(i).x == nr && warm[warmNum].get(i).y == nc) {
						nr = (i == 0) ? warm[warmNum].get(1).x : warm[warmNum].get(0).x;
						nc = (i == 0) ? warm[warmNum].get(1).y : warm[warmNum].get(0).y;
						break;
					}
				}
			}
			r = nr;
			c = nc;
		}
		return cnt;
	}
}
