package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bj2667_단지번호붙이기 {

	static class danzi{
		int r, c, cnt;

		public danzi(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}	
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int map[][] = new int [N][N];
		for (int i = 0; i < map.length; i++) {
			String s = in.readLine();
			for (int j = 0; j < map.length; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}// 입력 끝
		List<Integer> list = new ArrayList<Integer>();
		Queue<danzi> queue = new LinkedList<danzi>();
		boolean visit[][] = new boolean[N][N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					int cnt = 0;
					visit[i][j] = true;
					queue.add(new danzi(i, j, 1));
					while(!queue.isEmpty()) {
						danzi dan = queue.poll();
						cnt++;
						for (int d = 0; d < 4; d++) {
							int nr = dan.r + dr[d];
							int nc = dan.c + dc[d];
							if( nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == 0)
								continue;
							visit[nr][nc] = true;
							queue.add(new danzi(nr, nc, dan.cnt+1));
						}
					}//end while
					list.add(cnt);
				}
			}
		}//end for
	    Collections.sort(list);
		System.out.println(list.size());
		for (Integer num : list) {
			System.out.println(num);
		}	
	}
}
