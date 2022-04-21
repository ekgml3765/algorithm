package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14502_연구소_2회독 {

	static int N, M, map[][], ans = 0;
	static List<Point> arr, birus;
	static Point[] sel;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		arr = new ArrayList<>();
		birus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0 ) {
					arr.add(new Point(i, j));
				}
				if(map[i][j] == 2)
					birus.add(new Point(i,j));
			}
		}
		sel = new Point[3];
		comb(0,0);
		System.out.println(ans);
		
	}
	private static void comb(int idx, int s_idx) {
		if(s_idx == 3) {
			for (int i = 0; i < sel.length; i++) {
				map[sel[i].x][sel[i].y] = 1;
			}
			bfs();
			for (int i = 0; i < sel.length; i++) {
				map[sel[i].x][sel[i].y] = 0;
			}
			return;
		}
		if(idx == arr.size())
			return;
		sel[s_idx] = arr.get(idx);
		comb(idx+1, s_idx+1);
		comb(idx+1, s_idx);
	}
	private static void bfs() {
		int cnt = arr.size()-3;
		boolean visit[][] = new boolean[N][M];
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < birus.size(); i++) {
			Point p = birus.get(i);
			queue.add(p);
			visit[p.x][p.y] = true;
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] == 1)
					continue;
				visit[nr][nc] = true;
				cnt--;
				queue.add(new Point(nr, nc));
			}
		}
		ans = Math.max(ans, cnt);
	}
}
