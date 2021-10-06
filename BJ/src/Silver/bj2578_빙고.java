package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj2578_빙고 {
	static int map[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		visit = new boolean[5][5];
		HashMap<Integer, Point> hash = new HashMap<Integer, Point>();
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				hash.put(map[i][j],new Point(i, j));
			}
		}
		int cnt = 0;
		int ans = 0;
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				int num = Integer.parseInt(st.nextToken());
				Point p = hash.get(num);
				visit[p.x][p.y] = true;
				if(!flag && cnt >= 10) {
					flag = check();
					ans = cnt;
				}
			}
		}
		System.out.println(ans);	
	}
	private static boolean check() {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			int w = 0;
			int l = 0;
			for (int j = 0; j < 5; j++) {
				if(visit[i][j])
					w++;
				if(visit[j][i])
					l++;
			}
			if(w == 5)
				cnt++;
			if(l == 5)
				cnt++;
		}
		if(visit[0][0] && visit[1][1] && visit[2][2] && visit[3][3] && visit[4][4])
			cnt++;
		if(visit[0][4] && visit[1][3] && visit[2][2] && visit[3][1] && visit[4][0])
			cnt++;	
		if(cnt >= 3)
			return true;
		return false;	
	}
}
