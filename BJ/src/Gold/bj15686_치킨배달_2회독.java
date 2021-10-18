package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj15686_치킨배달_2회독 {
	static int N, M, map[][], ans;
	static List<Point> list, home;
	static Point sel[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		list = new ArrayList<Point>();
		home = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					home.add(new Point(i, j));
				if (map[i][j] == 2)
					list.add(new Point(i, j));
			}
		} // 입력 끝
		sel = new Point[M];
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int idx, int s_idx) {
		if(s_idx == M) {
			int sum = 0;
			for (Point p : home) {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < sel.length; i++) {
					int dis = Math.abs(sel[i].x - p.x) + Math.abs(sel[i].y - p.y);
					min = Math.min(min, dis);
				}
				sum += min;
			}
			ans = Math.min(sum, ans);
			return;
		}
		if(idx == list.size())
			return;
		sel[s_idx] = list.get(idx);
		comb(idx+1, s_idx+1);
		comb(idx+1, s_idx);
	}
}
