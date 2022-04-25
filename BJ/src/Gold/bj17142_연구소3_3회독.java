package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17142_연구소3_3회독 {
	static int N, M, map[][], birus[][], ans = Integer.MAX_VALUE, zeroCnt;
	static List<Point> list;
	static Point[] sel;

	static class Node {
		int r, c, cnt, time;

		public Node(int r, int c, int cnt, int time) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.time = time;
		}
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		list = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					list.add(new Point(i, j));
				if (map[i][j] == 0) {
					zeroCnt++;
				}
			}
		}

		sel = new Point[M];
		comb(0, 0);

		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
	}

	private static void comb(int idx, int s_idx) {
		if (s_idx == M) {
			bfs();
			return;
		}
		if (idx == list.size())
			return;

		sel[s_idx] = list.get(idx);
		comb(idx + 1, s_idx + 1);
		comb(idx + 1, s_idx);

	}

	private static void bfs() {
		birus = new int[N][N];
		int zero = zeroCnt;
		boolean visit[][] = new boolean[N][N];
		Queue<Node> queue = new LinkedList<Node>();
		for (int i = 0; i < sel.length; i++) {
			queue.add(new Node(sel[i].x, sel[i].y, 0, 0));
			visit[sel[i].x][sel[i].y] = true;
		}
		int time = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc])
					continue;
				if (map[nr][nc] == 1) {
					birus[nr][nc] = -1;
					continue;
				}
				visit[nr][nc] = true;
				// 새로운 바이러스 만났을 때
				if (map[nr][nc] == 2) {
					birus[nr][nc] = -2;
					queue.add(new Node(nr, nc, 0, node.time + 1));

				}
				// 빈칸
				if (map[nr][nc] == 0) {
					zero--;
					birus[nr][nc] = node.cnt + 1;
					queue.add(new Node(nr, nc, node.cnt + 1, node.time + 1));
					if (zero == 0) {
						time = node.time + 1;
					}
				}

			}

		}

		if (zero == 0)
			ans = Math.min(ans, time);

	}


}
