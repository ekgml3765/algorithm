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

public class bj2636_치즈 {

	static int N, M, cnt = 0;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cnt++;
			}
		} // 입력끝, 공기위주의 접근
		int time = 0;
		int before = 0;
		while (cnt > 0) {
			time++;
			before = cnt;
			bfs();
		}
		System.out.println(time);
		System.out.println(before);
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	private static void bfs() {
		List<Point> list = new ArrayList<>();
		Queue<Point> queue = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];
		queue.add(new Point(0, 0));
		visit[0][0] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc]) {
					visit[nr][nc] = true;
					if (map[nr][nc] == 1) {
						map[nr][nc] = 0;
						cnt--;
						list.add(new Point(nr, nc));
						continue;
					}
					queue.add(new Point(nr, nc));
				}
			}
		}
	}
}
