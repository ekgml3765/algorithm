package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj18428_감시피하기 {

	static int N;
	static char[][] map;
	static List<Point> teacher;
	static List<Point> arr;
	static Point[] sel;
	static String ans = "NO";
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		arr = new ArrayList<Point>();
		teacher = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'T')
					teacher.add(new Point(i, j));
				if (map[i][j] == 'X')
					arr.add(new Point(i, j));
			}
		}
		sel = new Point[3];
		comb(0, 0);
		System.out.println(ans);
	}

	static int cnt = 0;

	private static void comb(int idx, int s_idx) {
		if (s_idx == 3) {
			for (int i = 0; i < sel.length; i++) {
				Point p = sel[i];
				map[p.x][p.y] = 'O';
			}
			boolean flag = go();
			if (flag) {
				ans = "YES";
				return;
			}
			for (int i = 0; i < sel.length; i++) {
				Point p = sel[i];
				map[p.x][p.y] = 'X';
			}
			return;
		}
		if (idx == arr.size())
			return;
		sel[s_idx] = arr.get(idx);
		comb(idx + 1, s_idx + 1);
		comb(idx + 1, s_idx);
	}

	private static boolean go() {
		for (int i = 0; i < teacher.size(); i++) {
			Point t = teacher.get(i);
			for (int d = 0; d < 4; d++) {
				int nr = t.x;
				int nc = t.y;
				while (true) {
					nr += dr[d];
					nc += dc[d];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 'O')
						break;
					if (map[nr][nc] == 'S')
						return false;
				}
			}
		}
		return true;
	}
}
