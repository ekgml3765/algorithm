package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj21608_상어초등학교_2회독 {
	static int N, order[], map[][];
	static List<List<Integer>> students;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int good[] = {0, 1, 10, 100, 1000};
	static class Node implements Comparable<Node>{
		int r, c, like, bin;
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
					if(this.r == o.r)
						return this.c-o.c;
					return this.r-o.r;
				}
				return o.bin-this.bin;
			}
			return o.like-this.like;
		}		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int ans = 0;
		map = new int[N][N];
		order = new int[N*N];
		students = new ArrayList<>();
		for (int i = 0; i < N*N+1; i++) {
			students.add(new ArrayList<>());
		}
		for (int i = 0; i < N*N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			order[i] = Integer.parseInt(st.nextToken());
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			students.set(order[i], list);
		}
		//배치
		for (int i = 0; i < order.length; i++) {
			seat(order[i]);
		}
		//만족도 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = map[i][j];
				List<Integer> list = students.get(num);
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					if(list.contains(map[nr][nc]))
						cnt++;
				}
				ans += good[cnt];
			}
		}
		System.out.println(ans);
	}
	private static void seat(int num) {
		List<Node> candidate = new ArrayList<>();
		List<Integer> list = students.get(num);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					int like = 0;
					int bin = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;
						if(list.contains(map[nr][nc]))
							like++;
						if(map[nr][nc] == 0)
							bin++;
					}
					candidate.add(new Node(i, j, like, bin));
				}
			}
		}
		Collections.sort(candidate);
		map[candidate.get(0).r][candidate.get(0).c] = num;
	}
}
