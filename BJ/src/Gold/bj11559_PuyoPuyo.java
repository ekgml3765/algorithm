package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bj11559_PuyoPuyo {

	static char map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][];
		for (int i = 0; i < 12; i++) {
			String s = in.readLine();
			map[i] = s.toCharArray(); 
		}		
		int ans = 0;
		while(true) {
			bfs();
			if(!flag)
				break;
			ans++;
			down();
		}
		System.out.println(ans);
	}
	static class Color{
		int r, c;
		char color;

		public Color(int r, int c, char color) {
			this.r = r;
			this.c = c;
			this.color = color;
		}
		
	}
	private static void down() {
		for (int j = 0; j < 6; j++) {
			List<Color> list = new ArrayList<>();
			for (int i = 11; i >= 0; i--) {
				if(map[i][j] != '.')
					list.add(new Color(i, j, map[i][j]));
			}
			int r = 11;
			for (int i = 0; i < list.size(); i++) {
				Color color = list.get(i);
				map[color.r][color.c] = '.';
				map[r][j] = color.color;
				r--;
			}
		}
	}
	private static void bfs() {
		flag = false;
		Queue<Point> queue = new LinkedList<Point>();
		boolean visit[][] = new boolean[12][6];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if(map[i][j] != '.') {
					visit[i][j] = true;
					queue.add(new Point(i, j));
					List<Point> popList = new ArrayList();
					char color = map[i][j];
					while(!queue.isEmpty()) {
						Point p = queue.poll();
						popList.add(p);
						
						for (int d = 0; d < 4; d++) {
							int nr = p.x + dr[d];
							int nc = p.y + dc[d];
							if(nr < 0 || nc < 0 || nr >= 12 || nc >= 6 || visit[nr][nc] || map[nr][nc] != color)
								continue;
							visit[nr][nc] = true;
							queue.add(new Point(nr,nc));
						}
					}
					if(popList.size() >= 4) {
						flag = true;
						for (Point point : popList) {
							map[point.x][point.y] = '.';
						}
					}
				}
			}
		}
		
	}
}
