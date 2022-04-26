package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj21609_상어중학교_3회독 {

	static int N, M, map[][], ans = 0;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class group implements Comparable<group> {
		int g_r, g_c, rainbow, size;
		List<Point> list = new ArrayList<>();

		public group(int g_r, int g_c, int rainbow, int size, List<Point> list) {
			this.g_r = g_r;
			this.g_c = g_c;
			this.rainbow = rainbow;
			this.size = size;
			this.list = list;
		}

		@Override
		public String toString() {
			return "group [g_r=" + g_r + ", g_c=" + g_c + ", rainbow=" + rainbow + ", size=" + size + ", list=" + list
					+ "]";
		}

		@Override
		public int compareTo(group o) {
			if (o.size == this.size) {
				if (o.rainbow == this.rainbow) {
					if (o.g_r == this.g_r) {
						return o.g_c - this.g_c;
					}
					return o.g_r - this.g_r;
				}
				return o.rainbow - this.rainbow;
			}
			return o.size - this.size;
		}

	}

	static List<Point> delList;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					map[i][j] = -2;// 무지개 -2 처리
			}
		}

		while (true) {
			if(!blockGroup())
					break;
			del();
			down();
			rotate();
			down();
		}

		System.out.println(ans);
	}

	private static void rotate() {
		int newMap[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = N-1, jj = 0; j >= 0; j--, jj++) {
				newMap[jj][i] = map[i][j];
			}
		}
		for (int i = 0; i < newMap.length; i++) {
			map[i] = newMap[i].clone();
		}
	}

	private static void down() {
		for (int j = 0; j < N ; j++) {
			int s_r = N-1;
			while(s_r > 0) {
				if(map[s_r][j] != 0) {
					s_r--;
					continue;
				}
				//s_r이 있다! 무지개블록이랑, 일반블록 찾아
				boolean flag = false;
				int nr = s_r-1;
				while(true) {
					//범위 밖, 검정블록
					if(nr < 0 || map[nr][j] == -1) {
						s_r--;
						break;
					}
						
					if(map[nr][j] == 0) {
						nr--;
						continue;
					}
					flag = true;
					break;
				}
				
				if(flag) {
					while(true) {
						if(nr < 0)
							break;
						if(map[nr][j] == -1) {
							s_r = nr-1;
							break;
						}
						map[s_r][j] = map[nr][j];
						map[nr][j] = 0;
						s_r--;
						break;
					}
				}
			}
		}
	}

	private static void del() {
		for (Point p : delList) {
			map[p.x][p.y] = 0;
		}
		
		ans += Math.pow(delList.size(), 2);
	}

	private static boolean blockGroup() {

		List<group> groupList = new ArrayList<>();
		boolean visit[][] = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0 && !visit[i][j]) {
					int num = map[i][j];
					visit[i][j] = true;
					Queue<Point> queue = new LinkedList<Point>();
					queue.add(new Point(i, j));
					int g_r = i;
					int g_c = j;
					int rainbow = 0;
					List<Point> list = new ArrayList<>();
					List<Point> rainbowList = new ArrayList<>();
					while (!queue.isEmpty()) {
						Point p = queue.poll();
						list.add(p);
						for (int d = 0; d < 4; d++) {
							int nr = p.x + dr[d];
							int nc = p.y + dc[d];
							if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == -1 || map[nr][nc] == 0)
								continue;
							if (map[nr][nc] > 0 && map[nr][nc] != num)
								continue;
							visit[nr][nc] = true;
							if (map[nr][nc] == -2) {
								rainbow++;
								rainbowList.add(new Point(nr, nc));
							}
							queue.add(new Point(nr, nc));

						}
					}
					// 무지개 블록 처리
					for (Point p : rainbowList) {
						visit[p.x][p.y] = false;
					}
					int size = list.size();
					if (size < 2)
						continue;
					groupList.add(new group(g_r, g_c, rainbow, size, list));
				}
			}
		}

		if (groupList.size() == 0)
			return false;
		Collections.sort(groupList);	
		delList = groupList.get(0).list;
		return true;

	}
}
