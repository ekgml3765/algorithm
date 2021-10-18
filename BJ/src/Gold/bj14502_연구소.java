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

public class bj14502_연구소 {
	static int N, M, map[][], ans = 0;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static Point sel[];
	static List<Point> list, birus;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<Point>();
		birus = new ArrayList<Point>();
		sel = new Point[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					list.add(new Point(i, j));
				if (map[i][j] == 2)
					birus.add(new Point(i, j));
			}
		} // 입력 끝
		comb(0, 0); // 벽 3개 세울 곳 뽑아(조합)
		System.out.println(ans);
	}

	private static void comb(int idx, int s_idx) {
		if (s_idx == 3) {
			for (int i = 0; i < sel.length; i++) {
				map[sel[i].x][sel[i].y] = 1;
			}
			bfs();// 바이러스 퍼져 bfs
			// 원복
			for (int i = 0; i < sel.length; i++) {
				map[sel[i].x][sel[i].y] = 0;
			}
			return;
		}
		if (idx == list.size())
			return;
		sel[s_idx] = list.get(idx);
		comb(idx + 1, s_idx + 1);
		comb(idx + 1, s_idx);
	}

	private static void bfs() {
		int zero = list.size()-3;
		Queue<Point> queue = new LinkedList<Point>();
		boolean visit[][] = new boolean[N][M];
		for (Point point : birus) {
			queue.add(point);
			visit[point.x][point.y] = true;
		}
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] != 0)
					continue;
				zero--;
				visit[nr][nc] = true;
				queue.add(new Point(nr, nc));
			}
		}
		ans = Math.max(ans, zero);
	}
}
