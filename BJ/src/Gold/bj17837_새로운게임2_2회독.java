package Gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj17837_새로운게임2_2회독 {

	static int N, K, map[][];
	static List<Integer> horse[][];
	static int dr[] = { 0, 0, -1, 1 };
	static int dc[] = { 1, -1, 0, 0 };

	static class Node {
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
		
		
	}

	static Node arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		arr = new Node[K + 1];
		horse = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				horse[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(in.readLine());
			int num = i;
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			arr[i] = new Node(num, r, c, d);
			horse[r][c].add(num);
		}
		Integer [] a = new Integer[3];
		int turn = 1;
		while (true) {
			if (turn > 1000)
				break;
			if (move())
				break;
			turn++;
		}
		System.out.println((turn > 1000) ? -1 : turn);

	}

	private static boolean move() {

		for (int i = 1; i < arr.length; i++) {
			Node node = arr[i];
			int nr = node.r + dr[node.d];
			int nc = node.c + dc[node.d];

			// 이동칸이 범위밖 or 파랑
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 2) {
				// 반대로 하고 한칸 이동
				node.d = (node.d % 2 == 0) ? node.d + 1 : node.d - 1;
				nr = node.r + dr[node.d];
				nc = node.c + dc[node.d];
				// 이동 불가면 그대로
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 2) {
					arr[i] = node;
					continue;
				} else {
					go(map[nr][nc], node, i, nr, nc);	
				}		
			}
			else if(map[nr][nc] == 1 ) {// 빨강
				go(1, node, i, nr, nc);
			}else{// 흰색
				go(0, node, i, nr, nc);
			}

			// 4마리 쌓였는지 체크하고 맞다면 true하고 끝
			if (horse[node.r][node.c].size() >= 4) {
				return true;
			}
		}

		return false;
	}

	private static void go(int color, Node node, int idx, int nr, int nc) {
		List<Integer> s1 = new ArrayList<>();
		List<Integer> s2 = new ArrayList<>();
		s1 = horse[node.r][node.c];
		for (int j = 0; j < s1.size(); j++) {
			if (s1.get(j) == node.num) {
				s2 = new ArrayList<>(s1.subList(j, s1.size()));
				s1.removeAll(s2);
				break;
			}
		}
		horse[node.r][node.c] = s1;
		for (Integer num : s2) {
			arr[num].r = nr;
			arr[num].c = nc;
		}
		
		// 흰색
		if (color == 0) {
			horse[nr][nc].addAll(s2);

		} else { // 빨강
			Collections.reverse(s2);
			horse[nr][nc].addAll(s2);
		}
		node.r = nr;
		node.c = nc;
		arr[idx] = node;
	}
}
