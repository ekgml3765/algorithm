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

public class bj20058_마법사상어와파이어스톰_3회독 {

	static int N, Q, map[][], newMap[][], L, ans1 = 0, ans2 = 0;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		Q = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < Q; i++) {
			int L = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
			divide(L);
			ice();
		}
		
		//남아있는 얼음 합
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans1 += map[i][j];
			}
		}
		//큰 덩어리 칸 개수
		bfs();
		System.out.println(ans1 + "\n" + ans2);
	}

	private static void ice() {
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] > 0) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if( nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0)
							continue;
						cnt++;
					}
					if(cnt < 3)
						list.add(new Point(i, j));
				}
			}
		}
		for (Point p : list) {
			map[p.x][p.y]--;
		}
	}

	private static void divide(int L) {
		newMap = new int[N][N];
		for (int i = 0; i < N; i+=L) {
			for (int j = 0; j < N; j+=L) {
				rotate(i, j, L);
			}
		}
		for (int k = 0; k < newMap.length; k++) {
			map[k] = newMap[k].clone();
		}
		
	}

	private static void rotate(int i, int j, int L) {
		for (int r = i, cc = j+L-1; r < i+L; r++, cc--) {
			for (int c = j, rr = i; c < j+L; c++, rr++) {
				newMap[rr][cc] = map[r][c];
			}
		}	
	}

	private static void bfs() {
		boolean visit[][] = new boolean[N][N];
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0 && !visit[i][j]) {
					int cnt = 1;
					queue.add(new Point(i, j));
					visit[i][j] = true;
					while(!queue.isEmpty()) {
						Point p = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nr = p.x + dr[d];
							int nc = p.y + dc[d];
							if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == 0)
								continue;
							cnt++;
							visit[nr][nc] = true;
							queue.add(new Point(nr, nc));
						}
					}
					ans2 = Math.max(ans2, cnt);
				}
			}
		}
	}
}
