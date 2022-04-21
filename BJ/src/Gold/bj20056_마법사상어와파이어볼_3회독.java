package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj20056_마법사상어와파이어볼_3회독 {

	static int N, M, K;
	static class Ball{
		int r, c, m, d, s;

		public Ball(int r, int c, int m, int d, int s) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.d = d;
			this.s = s;
		}		
	}
	static List<Ball> fireBall;
	static HashMap<Point, List<Ball>> map;
	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int ans = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fireBall = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireBall.add(new Ball(r, c, m, d, s));
		}
	
		for (int i = 0; i < K; i++) {
			move();
		}		
		for (Ball b : fireBall) {
			ans += b.m;
		}
		System.out.println(ans);
	}
	
	private static void move() {
		map = new HashMap<>();
		for (int i = 0; i < fireBall.size(); i++) {
			Ball b = fireBall.get(i);
			int nr = (N + ((b.r+dr[b.d]*b.s) % N)) % N;
			int nc = (N + ((b.c+dc[b.d]*b.s) % N)) % N;
			b.r = nr;
			b.c = nc;
			map.computeIfAbsent(new Point(nr, nc), k -> new ArrayList<>()).add(b);
		}
		
		fireBall.clear();
		for (Point key : map.keySet()) {
			List<Ball> list = map.get(key);
			if(list.size() == 1)
				fireBall.add(list.get(0));
			else {
				int m = 0;
				int s = 0;
				boolean even = false;
				boolean odd = false;
				for (Ball ball : list) {
					m += ball.m;
					s += ball.s;
					if(ball.d%2==0)
						even = true;
					else
						odd = true;
				}
				m = m/5;
				s = s / list.size();
				int d = (even&&odd)? 1: 0;
				if(m == 0)
					continue;
				for (int i = 0; i < 4; i++) {
					fireBall.add(new Ball(key.x, key.y, m, d, s));
					d+=2;
				}
			}
		}
		
	}
}
