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

public class bj20058_마법사상어와파이어스톰 {

	static int N, Q, size;
	static int map[][], stage[], newMap[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int ans = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		map = new int[size][size];
		stage = new int[Q];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < Q; i++) {
			stage[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < Q; i++) {
			int L = stage[i];
			divide(L);// 부분격자 나누기 - 시계방향 90도 회전
			ice();// 얼음 줄어들기 -1씩 0미만은 불가
		}
		int sum = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum += map[i][j];
			}
		}
		bfs();
		System.out.println(sum); // 남아있는 얼음 합
		System.out.println(ans); // 덩어리 수
	}

	// 큰 덩어리칸 갯수
	private static void bfs() {
		boolean visit[][] = new boolean[size][size];
		Queue<Point> queue = new LinkedList<Point>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(map[i][j] != 0 && !visit[i][j]) {
					queue.add(new Point(i, j));
					visit[i][j] = true;
					int cnt = 1;
					while(!queue.isEmpty()) {
						Point p = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nr = p.x + dr[d];
							int nc = p.y + dc[d];
							if(nr >= 0 && nc >= 0 && nr < size && nc < size && !visit[nr][nc] && map[nr][nc] != 0) {
								visit[nr][nc] = true;
								cnt++;
								queue.add(new Point(nr, nc));
							}
						}
					}
					ans = Math.max(ans, cnt);
				}
			}
		}
	}
	// 얼음 줄어들기
	private static void ice() {
		List<Point> iceList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] > 0) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr >= 0 && nc >= 0 && nr < size && nc < size) {
							if (map[nr][nc] > 0)
								cnt++;
						}
					}
					if (cnt < 3)
						iceList.add(new Point(i, j));
				}
			}
		}
		for (Point point : iceList) {
			map[point.x][point.y]--;
		}
	}
	// 부분격자 나누기
	private static void divide(int L) {
		int can = (int) Math.pow(2, L);
		newMap = new int[size][size];
		for (int i = 0; i < size; i += can) {
			int start_r = i;
			int end_r = i + can - 1;
			for (int j = 0; j < size; j += can) {
				int start_c = j;
				int end_c = j + can - 1;
				// 시계방향 90도
				rotation(start_r, end_r, start_c, end_c, can);
			}
		}
		for (int i = 0; i < size; i++) {
			map[i] = newMap[i].clone();
		}
	}
	// 시계방향 90도 회전
	private static void rotation(int start_r, int end_r, int start_c, int end_c, int can) {
		for (int i = start_r, c = end_c; i <= end_r; i++, c--) {
			List<Integer> list = new ArrayList<>();
			for (int j = start_c; j <= end_c; j++) {
				list.add(map[i][j]);
			}
			for (int r = start_r, idx = 0; r <= end_r; r++, idx++) {
				newMap[r][c] = list.get(idx);
			}
		}

	}
}
