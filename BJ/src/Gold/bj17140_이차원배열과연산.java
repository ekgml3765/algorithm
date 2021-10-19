package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj17140_이차원배열과연산 {
	static int R, C, map[][], r, c, k, ans = -1;

	static class Node implements Comparable<Node> {
		int num, cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Node o) {
			if (this.cnt == o.cnt) {
				return this.num - o.num;
			}
			return this.cnt - o.cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		R = 3;
		C = 3;
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		map = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (map[r][c] == k)
			System.out.println(0);
		else {
			for (int t = 1; t <= 100; t++) {
				solve();
				if (map[r][c] == k) {
					ans = t;
					break;
				}
			}
			System.out.println(ans);
		}
	}

	private static void solve() {
		int newMap[][] = new int[100][100];
		// R연산
		if (C <= R) {
			int max = C;
			for (int i = 0; i < R; i++) {
				HashMap<Integer, Integer> hash = new HashMap<>();
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 0)
						continue;
					hash.put(map[i][j], hash.getOrDefault(map[i][j], 0) + 1);
				}
				List<Node> list = new ArrayList<Node>();
				for (Integer num : hash.keySet()) {
					list.add(new Node(num, hash.get(num)));
				}
				Collections.sort(list);
				max = Math.max(max, (list.size() * 2 > 100) ? 100 : list.size() * 2);
				int j = 0;
				for (Node node : list) {
					newMap[i][j] = node.num;
					j++;
					if(j >= 100)
						break;
					newMap[i][j] = node.cnt;
					j++;
					if(j >= 100)
						break;
				}
			}
			C = max;
			for (int i = 0; i < R; i++) {
				map[i] = newMap[i].clone();
			}
		} else {// C연산
			int max = R;
			for (int j = 0; j < C; j++) {
				HashMap<Integer, Integer> hash = new HashMap<>();
				for (int i = 0; i < R; i++) {
					if (map[i][j] == 0)
						continue;
					hash.put(map[i][j], hash.getOrDefault(map[i][j], 0) + 1);
				}
				List<Node> list = new ArrayList<Node>();
				for (Integer num : hash.keySet()) {
					list.add(new Node(num, hash.get(num)));
				}
				Collections.sort(list);
				max = Math.max(max, (list.size() * 2 > 100) ? 100 : list.size() * 2);
				int i = 0;
				for (Node node : list) {
					newMap[i][j] = node.num;
					i++;
					if(i >= 100)
						break;
					newMap[i][j] = node.cnt;
					i++;
					if(i >= 100)
						break;
				}
			}
			R = max;
			for (int j = 0; j < C; j++) {
				for (int i = 0; i < R; i++) {
					map[i][j] = newMap[i][j];
				}
			}
		}
	}
}
