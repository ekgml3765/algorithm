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

public class bj16234_인구이동_2회독 {
	static int N, L, R, map[][], newMap[][];
	static boolean visit[][], flag;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int ans = 0;
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int t = 0; t <= 2000; t++) {
			visit = new boolean[N][N];
			flag = false;
			newMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						visit[i][j] = true;
						bfs(i, j);
					}
				}
			}
			if(!flag)
				break;
			for (int i = 0; i < N; i++) {
				map[i] = newMap[i].clone();
			}
			ans++;
		}
		System.out.println(ans);
	}
	private static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(i, j));
		List<Point> list = new ArrayList<>();
		list.add(new Point(i, j));
		int sum = map[i][j];
		int cnt = 1;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc])
					continue;
				int dif = Math.abs(map[p.x][p.y] - map[nr][nc]);
				if(dif < L || dif > R)
					continue;
				visit[nr][nc] = true;
				cnt++;
				sum += map[nr][nc];
				list.add(new Point(nr, nc));
				queue.add(new Point(nr, nc));
			}
		}
		if(list.size() > 1) {
			flag = true;
			int num = sum / cnt;
			for (Point point : list) {
				newMap[point.x][point.y] = num;
			}
		}else {
			newMap[i][j] = map[i][j];
		}
			
	}
}
