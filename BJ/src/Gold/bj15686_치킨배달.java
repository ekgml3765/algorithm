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

public class bj15686_치킨배달 {

	static int N, M, map[][], sel[], ans = Integer.MAX_VALUE;
	static List<Point> list, home;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new ArrayList<>();
		home = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					list.add(new Point(i, j));
				if(map[i][j] == 1)
					home.add(new Point(i, j));
			}
		}
		sel = new int [M];
		comb(0,0);
		System.out.println(ans);
	}
	private static void comb(int idx, int s_idx) {
		if(s_idx == M) {
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < sel.length; j++) {
					int ds = Math.abs(home.get(i).x - list.get(sel[j]).x) +  Math.abs(home.get(i).y - list.get(sel[j]).y);
					min = Math.min(min, ds);
				}
				sum += min;
			}
			ans = Math.min(ans, sum);
			return;
		}
		if(idx == list.size())
			return;
		sel[s_idx] = idx;
		comb(idx+1, s_idx+1);
		comb(idx+1, s_idx);
	}
}
