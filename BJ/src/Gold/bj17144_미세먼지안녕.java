package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17144_미세먼지안녕 {
	static int R, C, T, map[][], ans;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static List<Point> list;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[R][C];
		list = new ArrayList<Point>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1)
					list.add(new Point(i, j));
			}
		} // 입력
		for (int i = 0; i < T; i++) {
			// 미세먼지 확산
			spread();
			// 공기청정기 작동
			move();
		}
		// 남아있는 양
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					ans += map[i][j];
			}
		}
		System.out.println(ans);
	}

	private static void move() {
		// 반시계
		Point u = list.get(0);
		int tmp1 = map[u.x - 1][0];
		for (int i = u.x - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			map[0][j] = map[0][j + 1];
		}
		for (int i = 0; i < u.x; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int j = C - 1; j > 1; j--) {
			map[u.x][j] = map[u.x][j - 1];
		}
		map[u.x][1] = 0;
		// 시계
		Point d = list.get(1);
		int tmp2 = map[d.x + 1][0];
		for (int i = d.x + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			map[R - 1][j] = map[R - 1][j + 1];
		}
		for (int i = R - 1; i > d.x; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		for (int j = C - 1; j > 1; j--) {
			map[d.x][j] = map[d.x][j - 1];
		}
		map[d.x][1] = 0;
	}

	private static void spread() {
		int newMap[][] = new int[R][C];
		Queue<Point> queue = new LinkedList<Point>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					queue.add(new Point(i, j));
			}
		}
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int cnt = 0;
			int div = map[p.x][p.y] / 5;
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == -1)
					continue;
				newMap[nr][nc] += div;
				cnt++;
			}
			newMap[p.x][p.y] += map[p.x][p.y] - (div * cnt);
		}
		for (int i = 0; i < newMap.length; i++) {
			map[i] = newMap[i].clone();
		}
		map[list.get(0).x][list.get(0).y] = -1;
		map[list.get(1).x][list.get(1).y] = -1;
	}
}
