package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj21608_상어초등학교_3회독 {

	static class Node implements Comparable<Node>{
		int r, c, like, empty;

		public Node(int r, int c, int like, int empty) {
			this.r = r;
			this.c = c;
			this.like = like;
			this.empty = empty;
		}

		@Override
		public int compareTo(Node o) {
			if(o.like == this.like) {
				if(o.empty == this.empty) {
					if(this.r == o.r)
						return this.c-o.c;
					return this.r - o.r;
				}
				return o.empty-this.empty;
			}
			return o.like - this.like;
		}
		
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		boolean students[][] = new boolean[N*N+1][N*N+1];
		int order[] = new int[N*N];
		int map[][] = new int[N][N];
		int ans = 0;
		for (int i = 0; i < N*N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			order[i] = r;
			for (int j = 0; j < 4; j++) {
				int c = Integer.parseInt(st.nextToken());
				students[r][c] = true;
			}
		}
		for (int i = 0; i < order.length; i++) {
			int s = order[i];
			List<Node> list = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == 0) {
						int empty = 0, like = 0;
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;
							if(map[nr][nc] == 0 )
								empty++;
							if(students[s][map[nr][nc]])
								like++;
						}
						list.add(new Node(r, c, like, empty));
					}
				}
			}
			Collections.sort(list);
			Node node = list.get(0);
			map[node.r][node.c] = s;
		}
		int score[] = {0, 1, 10, 100, 1000};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int s = map[i][j];
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					if(students[s][map[nr][nc]])
						cnt++;
				}
				ans += score[cnt];
			}		
		}
		System.out.println(ans);
	}
}
