package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj19237_어른상어_3회독 {

	static int N, M, k, map[][];

	static class Node implements Comparable<Node> {
		int num, r, c, d;

		public Node(int num, int r, int c, int d) {
			this.num = num;
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", r=" + r + ", c=" + c + ", d=" + d + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.num - o.num;
		}

	}

	static List<Node> sharList;
	static int info[][][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int [][] delmap;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		sharList = new ArrayList<>();
		info = new int[M][4][4];
		delmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					sharList.add(new Node(map[i][j], i, j, 0));
					delmap[i][j] = k;
				}
					
			}
		}
		st = new StringTokenizer(in.readLine());
		Collections.sort(sharList);
		for (int i = 0; i < M; i++) {
			int d = Integer.parseInt(st.nextToken()) - 1;
			Node node = sharList.get(i);
			node.d = d;
			sharList.set(i, node);
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(in.readLine());
				for (int t = 0; t < 4; t++) {
					int d = Integer.parseInt(st.nextToken()) - 1;
					info[i][j][t] = d;
				}
			}
		}
		int ans = -1;
		int time = 1;
		while (time < 1001) {
			//상어이동->냄새뿌려
			move(time);
			if(sharList.size() == 1) {
				ans = time;
				break;
			}
			//뿌린 냄새 제거
			del(time);
			time++;
		}
		System.out.println(ans);

	}
	
	
	private static void move(int time) {
		HashMap<Point, Node> moveShark = new HashMap<Point, Node>();
		for (int i = 0; i < sharList.size(); i++) {
			Node shark = sharList.get(i);
			boolean flag = true;
			for (int j = 0; j < 4; j++) {
				int nd = info[shark.num-1][shark.d][j];
				int nr = shark.r + dr[nd];
				int nc = shark.c + dc[nd];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != 0)
					continue;
				flag = false;
				shark.r = nr;
				shark.c = nc;
				shark.d= nd;
				break;
			}
			//자기가 왔던 방향의 우선순위에 따라!!
			if(flag) {
				for (int j = 0; j < 4; j++) {
					int nd = info[shark.num-1][shark.d][j];
					int nr = shark.r + dr[nd];
					int nc = shark.c + dc[nd];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					if(map[nr][nc] == shark.num) {
						shark.r = nr;
						shark.c = nc;
						shark.d = nd;
						break;
					}
				}
			}
			//기존 자리에 있는지 확인
			Point key = new Point(shark.r, shark.c);
			if(moveShark.containsKey(key) && shark.num < moveShark.get(key).num ) {
				moveShark.put(key, shark);
			}
			if (!moveShark.containsKey(key))
				moveShark.put(key, shark);
		}
		//냄새뿌려
		sharList.clear();
		for (Point p : moveShark.keySet()) {
			Node shark = moveShark.get(p);
			map[shark.r][shark.c] = shark.num;
			delmap[shark.r][shark.c] = time+k;
			sharList.add(shark);
		}
		
	}

	private static void del(int time) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(delmap[i][j] == time) {
					delmap[i][j] = 0;
					map[i][j] = 0;
				}
			}
		}
	}
}
