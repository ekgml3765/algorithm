package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj20056_마법사상어와파이어볼_2회독 {
	static int N, M, K, ans = 0;

	static class Node {
		int r, c, m, s, d;

		public Node(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
		
		
	}

	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static HashMap<Point, List<Node>> map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			Point p = new Point(r, c);
			map.computeIfAbsent(p, k -> new ArrayList<Node>()).add(new Node(r, c, m, s, d));
		}
		for (int i = 0; i < K; i++) {
			move();
			go();
		}
		for (Point p : map.keySet()) {
			List<Node> list = map.get(p);
			for (Node node : list) {
				ans += node.m;
			}
		}
		System.out.println(ans);
	}

	private static void go() {
		HashMap<Point, List<Node>> map2 = new HashMap<>();
		for (Point key : map.keySet()) {
			List<Node> list = map.get(key);
			if (list.size() == 1) {
				Node node = list.get(0);
				map2.computeIfAbsent(new Point(node.r, node.c), k -> new ArrayList<Node>()).add(node);
			} else {
				int m = 0;
				int s = 0;
				boolean odd = false;
				boolean even = false;
				for (Node node : list) {
					m += node.m;
					s += node.s;
					if (node.d % 2 == 0)
						even = true;
					else
						odd = true;
				}
				s = s / list.size();
				m = m / 5;
				if (m == 0)
					continue;
				int d = (odd && even == true) ? 1 : 0;
				for (int i = d; i <= (d + 6); i += 2) {
					map2.computeIfAbsent(new Point(key.x, key.y), k -> new ArrayList<Node>())
							.add(new Node(key.x, key.y, m, s, i));
				}
			}
		}
		map = map2;
	}

	private static void move() {
		HashMap<Point, List<Node>> map2 = new HashMap<>();
		for (Point key : map.keySet()) {
			List<Node> list = map.get(key);
			for (Node node : list) {
				int nr = node.r + (dr[node.d] * node.s);
				int nc = node.c + (dc[node.d] * node.s);
				nr = (nr >= 0) ? nr % N : (N - (-nr % N)) % N;
				nc = (nc >= 0) ? nc % N : (N - (-nc % N)) % N;
				node.r = nr;
				node.c = nc;
				map2.computeIfAbsent(new Point(nr, nc), k -> new ArrayList<Node>()).add(node);
			}
		}
		map = map2;
	}
}
