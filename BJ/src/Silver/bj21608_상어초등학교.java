package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj21608_상어초등학교 {

	static class Node implements Comparable<Node>{
		int r;
		int c;
		int like;
		int bin;
		
		public Node(int r, int c, int like, int bin) {
			this.r = r;
			this.c = c;
			this.like = like;
			this.bin = bin;
		}
		
		@Override
		public int compareTo(Node o) {
			if(o.like == this.like) {
				if(o.bin == this.bin) {
					if(this.r == o.r) {
						return this.c - o.c;
					}
					return this.r - o.r;
				}
				return o.bin - this.bin;
			}
			return o.like - this.like;
		}
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int map[][] = new int[N][N];
		Integer students[][] = new Integer[N*N + 1][4];
		int order[] = new int[N*N + 1];
		for (int i = 1; i < students.length; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				students[idx][j] = Integer.parseInt(st.nextToken());
			}
			order[i] = idx;
		}
		
		for (int idx = 1; idx < order.length; idx++) {
			int studentNum = order[idx];
			List<Node> list = new ArrayList<Node>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != 0) continue;
					//빈칸에 대해서
					int bin = 0;
					int like = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;
						int num = map[nr][nc];
						//빈칸 세고
						if(num == 0)
							bin++;
						//좋아하는 학생 세
						if(num == students[studentNum][0] || num == students[studentNum][1] ||
								num == students[studentNum][2] || num == students[studentNum][3])
							like++;
					}
					list.add(new Node(i, j, like, bin));
				}
			}//end for
			//정렬
			Collections.sort(list);
			Node node = list.get(0);
			map[node.r][node.c] = studentNum;
		}
		//만족도
		int ans = 0;
		for (int i = 0; i <  N ; i++) {
			for (int j = 0; j < N; j++) {
				int student = map[i][j];
				int like = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					int num =  map[nr][nc];
					if(num == students[student][0] || num == students[student][1] ||
							num == students[student][2] || num == students[student][3])
						like++;
				}
				if(like == 0)
					ans += 0;
				if(like == 1)
					ans += 1;
				if(like == 2)
					ans += 10;
				if(like == 3)
					ans += 100;
				if(like == 4)
					ans += 1000;
			}
		}
		System.out.println(ans);
	}
}
