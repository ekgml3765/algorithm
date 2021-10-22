package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20058_마법사상어와파이어스톰_2회독 {
	static int N, Q, map[][], newMap[][],sum = 0, iceCnt = 0;
	static int[] list;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
		Q = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new int[Q];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < Q; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}//입력 끝
		//Q번 반복
		for (int i = 0; i < Q; i++) {
			int L = (int) Math.pow(2, list[i]);
			devide(L);//범위나눈다
		}
		
		//남아있는 얼음합
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		//덩어리수
		bfs();
		System.out.println(sum);
		System.out.println(iceCnt);
	}
	private static void devide(int L) {
		newMap = new int[N][N];
		for (int i = 0; i < N; i+= L) {
			for (int j = 0; j < N; j+=L) {
				rotation(i, j, L);	//90도 회전
			}
		}
		//얼음 줄여
		del();
		//복사
		for (int i = 0; i < N; i++) {
			map[i] = newMap[i].clone();
		}
	}
	private static void del() {
		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N || newMap[nr][nc] == 0)
						continue;
					cnt++;
				}
				if(cnt < 3) {
					list.add(new Point(i,j));
				}
			}
		}
		for (Point p : list) {
			if(newMap[p.x][p.y] > 0)
				newMap[p.x][p.y]--;
		}
	}
	private static void rotation(int R, int C, int L) {
		for (int i = R, c = C+L-1; i < R + L; i++, c--) {
			for (int j = C, r = R ; j < C + L; j++, r++) {
				newMap[r][c] = map[i][j];
			}
		}
		
	}
	private static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		boolean visit[][] = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0 && !visit[i][j]) {
					int cnt = 0;
					visit[i][j] = true;
					queue.add(new Point(i, j));
					while(!queue.isEmpty()) {
						Point p = queue.poll();
						cnt++;
						for (int d = 0; d < 4; d++) {
							int nr = p.x + dr[d];
							int nc = p.y + dc[d];
							if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc]==0)
								continue;
							visit[nr][nc] = true;
							queue.add(new Point(nr, nc));
						}
					}
					iceCnt = Math.max(cnt, iceCnt);
				}
			}
		}
		
	}
}
