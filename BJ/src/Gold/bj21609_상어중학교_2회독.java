package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj21609_상어중학교_2회독 {
	static int N, M, map[][], ans = 0;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class block implements Comparable<block> {
		List<Point> list = new ArrayList<>();
		Point p = new Point();
		int rainbowCnt = 0;

		public block(List<Point> list, Point p, int rainbowCnt) {
			this.list = list;
			this.p = p;
			this.rainbowCnt = rainbowCnt;
		}

		@Override
		public int compareTo(block o) {
			if (o.list.size() == this.list.size()) {
				if (o.rainbowCnt == this.rainbowCnt) {
					if (o.p.x == this.p.x) {
						return o.p.y - this.p.y;
					}
					return o.p.x - this.p.x;
				}
				return o.rainbowCnt - this.rainbowCnt;
			}
			return o.list.size() - this.list.size();
		}

		@Override
		public String toString() {
			return "block [list=" + list + ", p=" + p + "]";
		}

	}

	static List<block> groupList;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력
		// 블록그룹 존재할때까지 반복
		while (true) {
			// 블록그룹 찾아
			groupList = new ArrayList<block>();
			find();
			if (groupList.size() == 0)
				break;
			// 가장큰 블록그룹 찾아 제거->점수 획득 (제거된거 다른 숫자로 표현)
			score();
			// 중력작용 -> 맵 변경
			down();
			// 90도 반시계 회전
			rotation();
			// 중력작용
			down();
		}
		System.out.println(ans);
	}

	private static void rotation() {
		int newMap[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = N - 1, k = 0; j >= 0; j--, k++) {
				newMap[k][i] = map[i][j];
			}
		}
		for (int i = 0; i < newMap.length; i++) {
			map[i] = newMap[i].clone();
		}
	}

	private static void down() {
		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i > 0; i--) {
				if (map[i][j] != 6)
					continue;
				int r = i - 1;
				int c = j;
				boolean flag = false;
				for (int k = r; k >= 0; k--) {
					if (map[k][c] == 0 || (1 <= map[k][c] && map[k][c] <= 5)) {
						flag = true;
						r = k;
						break;
					}
					if (map[k][c] == -1)
						break;
				}
				if (flag) {
					map[i][j] = map[r][c];
					map[r][c] = 6;
				}
			}
		}
	}

	private static void score() {
		Collections.sort(groupList);
		List<Point> list = groupList.get(0).list;
		int score = list.size() * list.size();
		for (Point p : list) {
			map[p.x][p.y] = 6; // 점수제거
		}
		ans += score;
	}

	private static void find() {
		Queue<Point> queue = new LinkedList<Point>();
		boolean check[][] = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((1 <= map[i][j] && map[i][j] <= 5) && !check[i][j]) {
					check[i][j] = true;
					boolean visit[][] = new boolean[N][N]; //무지개 0은 다 들어가므로
					visit[i][j] = true;
					queue.add(new Point(i, j));
					List<Point> list = new ArrayList<>();
					list.add(new Point(i, j));
					Point gihun = new Point(i, j);
					int color = map[i][j];
					int rainbowCnt = 0;
					while (!queue.isEmpty()) {
						Point p = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nr = p.x + dr[d];
							int nc = p.y + dc[d];
							if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc])
								continue;
							if (map[nr][nc] == color || map[nr][nc] == 0) {
								visit[nr][nc] = true;
								list.add(new Point(nr, nc));
								queue.add(new Point(nr, nc));
								if (map[nr][nc] != 0)
									check[nr][nc] = true;
								if (map[nr][nc] == 0)
									rainbowCnt++;
							}
						}
					}
					if (list.size() >= 2) {
						groupList.add(new block(list, gihun, rainbowCnt));
					}
				}
			}
		}

	}
}
