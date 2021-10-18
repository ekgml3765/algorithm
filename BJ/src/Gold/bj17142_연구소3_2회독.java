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

public class bj17142_연구소3_2회독 {
	static int N, M, map[][], ans;
	static List<Point> birus;
	static Point sel[];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int zeroCnt = 0;

	static class Node {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		birus = new ArrayList<Point>();
		sel = new Point[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					zeroCnt++;
				if (map[i][j] == 1)
					map[i][j] = -1;
				if (map[i][j] == 2)
					birus.add(new Point(i, j));
			}
		} // 입력 끝
		if (zeroCnt == 0) //빈칸이 아예 없을 경우
			ans = 0;
		else
			comb(0, 0);
		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
	}

	private static void comb(int idx, int s_idx) {
		if (s_idx == M) {
			bfs();
			return;
		}
		if (idx == birus.size())
			return;
		sel[s_idx] = birus.get(idx);
		comb(idx + 1, s_idx + 1);
		comb(idx + 1, s_idx);
	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		boolean visit[][] = new boolean[N][N];
		for (int i = 0; i < sel.length; i++) {
			queue.add(new Node(sel[i].x, sel[i].y, 0));
			visit[sel[i].x][sel[i].y] = true;
		}
		int zero = zeroCnt;
		int cnt = 0;
		out: while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == -1)
					continue;
				visit[nr][nc] = true;
				if (map[nr][nc] == 0) {
					zero--;
				}
				if (zero == 0) {
					ans = Math.min(ans, node.cnt+1);
					break out;
				}
				queue.add(new Node(nr, nc, node.cnt + 1));
			}
		}

	}
}
