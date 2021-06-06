package bj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16234_인구이동 {

	static int N, L, R, map[][], map2[][], cnt, sum, ans = 0;
	static boolean visit[][], visit2[][], onceOpen, isMoved;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visit = new boolean[N][N];
			onceOpen = false;
			map2 = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						bfs(i, j);
					}
				}
			}
			// 한번이라도 국경선이 안 열렸다면
			if (!onceOpen)
				break;
			ans++;
		}

		System.out.println(ans);
	}

	private static void bfs(int r, int c) { // 열어야할 국경선 다 염.
		Queue<Point> queue = new LinkedList<Point>();
		visit[r][c] = true;
		queue.add(new Point(r, c));

		List<Point> list = new ArrayList<Point>();
		sum = map[r][c];
		cnt = 1;
		while (!queue.isEmpty()) {

			Point p = queue.poll();
			list.add(p);

			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
					int diff = Math.abs(map[p.x][p.y] - map[nr][nc]);
					if (diff >= L && diff <= R) {
						visit[nr][nc] = true;
						queue.add(new Point(nr, nc));
						onceOpen = true;
						sum += map[nr][nc];
						cnt++;
					}
				}
			}

		}

		if (list.size() > 1) { // 평균계산
			int avg = sum / cnt;
			for (Point point : list) {
				map[point.x][point.y] = avg;
			}
		}

	}
}
