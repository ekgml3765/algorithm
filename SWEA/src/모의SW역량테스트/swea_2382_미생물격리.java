package 모의SW역량테스트;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_2382_미생물격리 {

	static int N, M, K;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Node {
		int r, c, d, cnt, time = 0;
		boolean flag = false;

		public Node(int r, int c, int cnt, int d) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", d=" + d + ", cnt=" + cnt + ", time=" + time + ", flag=" + flag
					+ "]";
		}

	}

	static Node list[];
	static int map[][];
	static Queue<Integer> queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			list = new Node[K + 1];
			queue = new LinkedList<Integer>();
			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(in.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken()) - 1;
				list[i] = new Node(r, c, cnt, d);
				queue.add(i);
			}
			move();	 
			for (int i = 1; i <= K; i++) {
				if (!list[i].flag) {
					ans += list[i].cnt;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void move() {
		for (int i = 0; i < M; i++) {
			map = new int[N][N];
			HashMap<Point, List<Integer>> hash = new HashMap<Point, List<Integer>>();
			while (!queue.isEmpty()) {
				int num = queue.poll();
				Node node = list[num];
				int nr = node.r + dr[node.d];
				int nc = node.c + dc[node.d];
				if (nr == 0 || nc == 0 || nr == N - 1 || nc == N - 1) {
					node.d = (node.d % 2 == 0) ? node.d + 1 : node.d - 1;
					node.cnt = node.cnt / 2;
					node.flag = (node.cnt == 0) ? true : false;
				}
				if (map[nr][nc] != 0) {
					if(hash.get(new Point(nr, nc)) == null) {
						List<Integer> list = new ArrayList<>();
						list.add(map[nr][nc]);
						list.add(num);
					}else {
						hash.get(new Point(nr, nc)).add(num);
					}
				}
				node.r = nr;
				node.c = nc;
				node.time++;
				map[nr][nc] = num;
				list[num] = node;
			}
			for(Point p : hash.keySet()) {
				List<Integer> comp = hash.get(p);
				int num = comp.get(0);
				int max = list[num].cnt;
				int sum = list[num].cnt;
				System.out.println(comp.toString());
				for (int j = 1; j < comp.size(); j++) {
					sum += list[comp.get(i)].cnt;
					if(max < list[comp.get(i)].cnt) {
					    list[num].flag = true;
						max = list[comp.get(i)].cnt;
						num = comp.get(i);
					}else {
						list[comp.get(i)].flag = true;
					}
				}
				list[num].cnt = sum;
			}
			for (int j = 1; j <= K; j++) {
				if(!list[j].flag)
					queue.add(j);
			}
		}
	}
}
