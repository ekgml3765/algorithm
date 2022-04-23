package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj19238_스타트택시_2회독 {

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int N, M, map[][], success = 0, take = 0;
	static int t_r, t_c;
	static long t_f;

	static class Customer {
		int s_r, s_c, e_r, e_c;

		public Customer(int s_r, int s_c, int e_r, int e_c) {
			this.s_r = s_r;
			this.s_c = s_c;
			this.e_r = e_r;
			this.e_c = e_c;
		}
	}

	static class Node implements Comparable<Node> {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if (this.cnt == o.cnt) {
				if (this.r == o.r) {
					return this.c - o.c;
				}
				return this.r - o.r;
			}
			return this.cnt - o.cnt;
		}

	}

	static Customer[] customerList;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		t_f = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		customerList = new Customer[M + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = -1; // 벽
			}
		}
		st = new StringTokenizer(in.readLine());
		t_r = Integer.parseInt(st.nextToken()) - 1;
		t_c = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int s_r = Integer.parseInt(st.nextToken()) - 1;
			int s_c = Integer.parseInt(st.nextToken()) - 1;
			int e_r = Integer.parseInt(st.nextToken()) - 1;
			int e_c = Integer.parseInt(st.nextToken()) - 1;
			Customer node = new Customer(s_r, s_c, e_r, e_c);
			map[node.s_r][node.s_c] = i; // 손님번호 map표시
			customerList[i] = node;
		}
		// M번 태우고 내리기
		for (int i = 1; i <= M; i++) {
			if (!getBfs()) // 1. 택시가 태울 손님 bfs
				break;
			if (!goBfs()) // 2. 손님 태워서 목적지까지 bfs
				break;
		}
		System.out.println((success == M) ? t_f : -1);

	}

	private static boolean getBfs() {
		boolean visit[][] = new boolean[N][N];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(t_r, t_c, 0));
		visit[t_r][t_c] = true;
		List<Node> getList = new ArrayList<>();
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (map[node.r][node.c] > 0) {
				getList.add(node);
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == -1)
					continue;
				// 연료 이하로만 움직일 수 있음
				if (node.cnt + 1 > t_f)
					continue;
				visit[nr][nc] = true;
				queue.add(new Node(nr, nc, node.cnt + 1));
			}

		}
		// 리스트 정렬 && 리스트가 0이면 꽝
		if (getList.size() == 0)
			return false;
		Collections.sort(getList);
		Node c = getList.get(0);
		take = map[c.r][c.c];
		t_r = c.r;
		t_c = c.c;
		t_f -= c.cnt;
		map[c.r][c.c] = 0;
		return true;
	}

	private static boolean goBfs() {
		boolean visit[][] = new boolean[N][N];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(t_r, t_c, 0));
		visit[t_r][t_c] = true;
		Customer cm = customerList[take];
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if ((node.r == cm.e_r && node.c == cm.e_c)) {
				t_f = (t_f - node.cnt) + (node.cnt * 2);
				success++;
				t_r = cm.e_r;
				t_c = cm.e_c;
				return true;
			}
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == -1)
					continue;
				// 연료 이하로만 움직일 수 있음
				if (node.cnt + 1 > t_f)
					continue;
				// 여러 사람이 서있어도 지나갈 수 있음
				visit[nr][nc] = true;
				queue.add(new Node(nr, nc, node.cnt + 1));

			}
		}
		return false;
	}

}
