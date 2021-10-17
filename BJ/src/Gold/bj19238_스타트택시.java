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

public class bj19238_스타트택시 {
	static int N, M, curr, map[][], cnt, R, C;
	static int people[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node>{
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if(this.cnt == o.cnt) {
				if(this.r == o.r)
					return this.c - o.c;
				return this.r - o.r;
			}
			return this.cnt - o.cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		curr = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cnt = 0; // 이동한 고객 수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					map[i][j] = -1;
			}
		}
		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken()) - 1;
		C = Integer.parseInt(st.nextToken()) - 1;
		people = new int[M + 1][4];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			people[i][0] = Integer.parseInt(st.nextToken()) - 1;
			people[i][1] = Integer.parseInt(st.nextToken()) - 1;
			people[i][2] = Integer.parseInt(st.nextToken()) - 1;
			people[i][3] = Integer.parseInt(st.nextToken()) - 1;
			map[people[i][0]][people[i][1]] = i;
		} // 입력끝
		boolean flag = false;
		for (int i = 0; i < M; i++) {
			if (!drive()) {
				flag = true;
				break;
			}
		}
		if (cnt != M || flag)
			System.out.println(-1);
		else {
			System.out.println(curr);
		}
	}

	private static boolean drive() {
		boolean visit[][] = new boolean[N][N];
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(R, C, 0));
		visit[R][C] = true;
		int num = 0;
		int del = 0;
		// 택시와 승객이 같은 위치에 있는 경우
		if (map[R][C] > 0) {
			num = map[R][C];
		} else {
		    List<Node> list = new ArrayList<Node>();
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				if (map[node.r][node.c] > 0 ) { //고객을 만났다.
					list.add(new Node(node.r, node.c, node.cnt));
					continue;
				}
				if (node.cnt < curr) {
					for (int d = 0; d < 4; d++) {
						int nr = node.r + dr[d];
						int nc = node.c + dc[d];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == -1)
							continue;
						visit[nr][nc] = true;
						queue.add(new Node(nr, nc, node.cnt + 1));
					}
				}
			}
			if(list.size()==0)
				return false;
			Collections.sort(list);
			num = map[list.get(0).r][list.get(0).c];
			del = list.get(0).cnt;
		}
		// 승객을 태우지 못하는 경우도 체크
		curr -= del;
		map[people[num][0]][people[num][1]] = 0; // 태운 고객 출발위치는 빈칸
		// 목적지까지 최단 거리로 이동
		R = people[num][0];
		C = people[num][1];
		if (!go(num) || curr == 0)
			return false;
		cnt++;
		return true;
	}

	private static boolean go(int num) {
		int arriveR = people[num][2];
		int arriveC = people[num][3];
		boolean visit[][] = new boolean[N][N];
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(R, C, 0));
		visit[R][C] = true;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.r == arriveR && node.c == arriveC) {
				R = node.r;
				C = node.c;
				curr -= node.cnt;
				curr += (node.cnt)*2;
				return true;
			}
			if (node.cnt < curr) {
				for (int d = 0; d < 4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == -1)
						continue;
					visit[nr][nc] = true;
					queue.add(new Node(nr, nc, node.cnt + 1));
				}
			}
		}
		return false;
	}
}
