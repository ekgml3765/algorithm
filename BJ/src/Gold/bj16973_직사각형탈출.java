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

public class bj16973_직사각형탈출 {

	static int N,M,map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static boolean visit[][];
	static class Rectangle{
		int r, c, cnt;

		public Rectangle(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}		
	}
	static int H, W;
	static List<Point> wall = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					wall.add(new Point(i,j));
			}
		}
		st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int startR = Integer.parseInt(st.nextToken())-1;
		int startC = Integer.parseInt(st.nextToken())-1;
		int endR = Integer.parseInt(st.nextToken())-1;
		int endC = Integer.parseInt(st.nextToken())-1;
		int ans = -1;
		Queue<Rectangle> queue = new LinkedList<>();
		visit[startR][startC] = true;
		queue.add(new Rectangle(startR, startC, 0));
		while(!queue.isEmpty()) {
			Rectangle R = queue.poll();
			if(R.r == endR && R.c == endC) {
				ans = R.cnt;
				break;
			}
			out: for (int d = 0; d < 4; d++) {
				int nr = R.r + dr[d];
				int nc = R.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] == 1)
					continue;
				if(nr+ H > N || nc + W > M)
					continue;
				for (Point p : wall) {
					if((nr <= p.x && p.x <= nr+H-1) && (nc<= p.y && p.y <= nc+W-1))
						continue out;
				}
				visit[nr][nc] = true;
				queue.add(new Rectangle(nr, nc, R.cnt+1));
			}
		}
		System.out.println(ans);
	}
}
