package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj3184_양 {
	static int R, C, sheep=0, wolf=0;
	static char map[][];
	static boolean visit[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'o')
					sheep++;
				if(map[i][j] == 'v')
					wolf++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '#' && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(sheep + " " + wolf);
	}
	private static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(i, j));
		visit[i][j] = true;
		int sCnt = 0;
		int wCnt = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(map[p.x][p.y] == 'o')
				sCnt++;
			if(map[p.x][p.y] == 'v')
				wCnt++;
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C || visit[nr][nc] || map[nr][nc] == '#')
					continue;
				visit[nr][nc] = true;
				queue.add(new Point(nr, nc));
			}
		}
		
		if(sCnt > 0 && wCnt > 0) {
			if(sCnt > wCnt)
				wolf -= wCnt;
			else
				sheep -= sCnt;
		}
		
	}
}
