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

public class bj16234_인구이동 {

	static int N, L, R, map[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		int day = 0;
		while(true) {
			boolean flag = bfs();
			if(!flag)
				break;
			day++;
		}
		System.out.println(day);
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	private static boolean  bfs() {
		visit = new boolean [N][N];
		Queue<Point> queue = new LinkedList<Point>();
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					visit[i][j] = true;
					queue.add(new Point(i, j));
					int cnt = 1;
					int sum = map[i][j];
					List<Point> list = new ArrayList<Point>();
					while(!queue.isEmpty()) {
						Point p = queue.poll();
						list.add(new Point(p.x,p.y));
						for (int d = 0; d < 4; d++) {
							int nr = p.x + dr[d];
							int nc = p.y + dc[d];
							if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc])
								continue;
							int num = Math.abs(map[p.x][p.y] - map[nr][nc]);
							if( L <= num && num <= R) {
								visit[nr][nc] = true;
								cnt++;
								sum += map[nr][nc];
								queue.add(new Point(nr, nc));
							}
						}
					}
					
					if(cnt > 1) {
						flag = false;
						int people = sum / cnt;
						for (Point point : list) {
							map[point.x][point.y] = people;
						}
					}
				}
			}
		}
		if(flag)
			return false;
		return true;
	}
}
