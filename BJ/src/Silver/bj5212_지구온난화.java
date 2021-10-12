package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj5212_지구온난화 {

	static int R, C;
	static char map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X') {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == '.')
							cnt++;
					}
					if(cnt >= 3)
						list.add(new Point(i,j));
				}
			}
		}
		for (Point p : list) {
			map[p.x][p.y] = '.';
		}
		int minR = R-1;
		int maxR = 0;
		int minC = C-1;
		int maxC = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'X') {
					minR = Math.min(minR, i);
					maxR = Math.max(maxR, i);
					maxC = Math.max(maxC, j);
					minC = Math.min(minC, j);
				}
			}
		}
		for (int i = minR; i <= maxR; i++) {
			for (int j = minC; j <= maxC ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
