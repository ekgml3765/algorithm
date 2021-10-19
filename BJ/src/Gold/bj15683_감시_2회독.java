package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj15683_감시_2회독 {
	static int N, M, map[][], ans;
	static List<Point> list;
	static int check[] = { 0, 4, 2, 4, 4, 1 };
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					ans++;
				if (1 <= map[i][j] && map[i][j] < 6)
					list.add(new Point(i, j));
			}
		}
		dfs(0, map);
		System.out.println(ans);
	}

	private static void dfs(int idx, int map[][]) {
		if (idx == list.size()) {
			int zero = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0)
						zero++;
				}
			}
			ans = Math.min(ans, zero);
			return;
		}
		int copy[][] = new int[N][M];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = map[i].clone();
		}
		Point p = list.get(idx);
		int num = map[p.x][p.y]; // 카메라 번호
		for (int i = 0; i < check[num]; i++) {
			eye(p, num, i, num);
			dfs(idx + 1, map);
			//원복
			for (int j = 0; j < copy.length; j++) {
				map[j] = copy[j].clone();
			}
		}
	}

	private static void eye(Point p, int num, int d, int v) {
		switch (num) {
		case 1: {
			go(p.x, p.y, d, v);
			break;
		}
		case 2: {
			for (int i = d; i <= d + 2; i += 2) {
				go(p.x, p.y, i, v);
			}
			break;
		}
		case 3: {
			for (int i = d; i <= d + 1; i++) {
				go(p.x, p.y, i % 4, v);
			}
			break;
		}
		case 4: {
			for (int i = d; i <= d + 2; i++) {
				go(p.x, p.y, i % 4, v);
			}
			break;
		}
		case 5: {
			for (int i = 0; i < 4; i++) {
				go(p.x, p.y, i, v);
			}
			break;
		}
		}
	}

	private static void go(int x, int y, int d, int num) {
		int nr = x;
		int nc = y;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 6)
				break;
			if (map[nr][nc] != 0) // 1~5번
				continue;
			map[nr][nc] = num;
		}

	}
}
