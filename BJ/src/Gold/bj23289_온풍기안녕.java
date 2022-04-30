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

public class bj23289_온풍기안녕 {

	// 기본 인접 방향
	static int dr[] = { 0, 0, 0, -1, 1 };
	static int dc[] = { 0, 1, -1, 0, 0 };

	// 온풍기 클래스 fan
	static class Fan {
		int r, c, d;

		public Fan(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Fan [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
	}

	static List<Fan> fanList; // 온풍기 리스트
	static List<Point> checkList;
	static int R, C, K, W, map[][], wall[][][], wind[][], ans; // 벽 3차원 맵, 온도맵;
	// 큐에 넣을 노드(퍼지기)
	static class Node {
		int r, c, k;

		public Node(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", k=" + k + "]";
		}
	}

	// 방향별로 탐색해서 퍼질곳 표시
	static int dir[][][] = { {}, { { 1 }, { 3, 1 }, { 4, 1 } }, // 1 우
			{ { 2 }, { 3, 2 }, { 4, 2 } }, // 2 좌
			{ { 3 }, { 2, 3 }, { 1, 3 } }, // 3 상
			{ { 4 }, { 2, 4 }, { 1, 4 } }, // 4 하
	};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		checkList = new ArrayList<>();
		fanList = new ArrayList<>();
		wall = new int[R][C][5];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 5) {
					checkList.add(new Point(i, j));
					map[i][j] = 0;
					continue;
				}
				if (map[i][j] > 0) {
					fanList.add(new Fan(i, j, map[i][j]));
					map[i][j] = 0;
				}

			}
		}
		W = Integer.parseInt(in.readLine());
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken());
			if (t == 0) {
				wall[r][c][3] = 1;
				if (r <= 0)
					continue;
				wall[r - 1][c][4] = 1;
			}
			if (t == 1) {
				wall[r][c][1] = 1;
				if (c >= C - 1)
					continue;
				wall[r][c + 1][2] = 1;
			}
		}
		// 입력끝
		// 성능테스트 - 100넘어가면 101 출력
		ans = 0;
		while (true) {
			if (ans > 100) {
				break;
			}
			// 모든 온풍이게서 바람이 나온다
			window();
			// 온도 조절된다
			control();
			// 온도가 1이상이 가장 바깥쪽 칸 1감소
			down();
			ans++;
			if (check())
				break;
		}

		System.out.println(ans);

	}

	private static boolean check() {
		for (int i = 0; i < checkList.size(); i++) {
			Point p = checkList.get(i);
			if (map[p.x][p.y] < K)
				return false;
		}
		return true;
	}

	private static void down() {
		// 모서리처리..
		for (int j = 0; j < C; j++) {
			map[0][j] = (map[0][j] > 0) ? map[0][j] - 1 : map[0][j];
			map[R - 1][j] = (map[R - 1][j] > 0) ? map[R - 1][j] - 1 : map[R - 1][j];
		}
		for (int i = 1; i < R - 1; i++) {
			map[i][0] = (map[i][0] > 0) ? map[i][0] - 1 : map[i][0];
			map[i][C - 1] = (map[i][C - 1] > 0) ? map[i][C - 1] - 1 : map[i][C - 1];
		}
	}

	private static void control() {
		int plus[][] = new int[R][C];
		boolean visit[][] = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				visit[i][j] = true;
				for (int d = 1; d <= 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					// 두칸 벽
					if (wall[i][j][d] == 1)
						continue;
					if (nr < 0 || nc < 0 || nr >= R || nc >= C || visit[nr][nc])
						continue;
					int cur = map[i][j];
					int next = map[nr][nc];
					int val = (Math.abs(cur - next)) / 4;
					if (cur >= next) {
						plus[i][j] -= val;
						plus[nr][nc] += val;
					} else {
						plus[i][j] += val;
						plus[nr][nc] -= val;
					}
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += plus[i][j];
			}
		}
	}

	private static void window() {
		wind = new int[R][C];

		for (Fan fan : fanList) {
			Queue<Node> queue = new LinkedList<>();
			boolean visit[][] = new boolean[R][C];
			int f_r = fan.r + dr[fan.d];
			int f_c = fan.c + dc[fan.d];
			if (f_r < 0 || f_c < 0 || f_r >= R || f_c >= C) {
				continue;
			}
			queue.add(new Node(f_r, f_c, 5));
			visit[f_r][f_c] = true;
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				if (node.k == 0)
					continue;
				wind[node.r][node.c] += node.k;

				out: for (int i = 0; i < 3; i++) {
					int nr = node.r;
					int nc = node.c;
					for (int j = 0; j < dir[fan.d][i].length; j++) {
						int d = dir[fan.d][i][j];
						// 벽 처리
						if (wall[nr][nc][d] == 1)
							continue out;
						nr += dr[d];
						nc += dc[d];
						if (nr < 0 || nc < 0 || nr >= R || nc >= C)
							continue out;
					}
					// 통과
					if (visit[nr][nc])
						continue out;
					visit[nr][nc] = true;
					queue.add(new Node(nr, nc, node.k - 1));
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += wind[i][j];
			}
		}

	}
}
