package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj3190_뱀 {
	static int N, K, L,map[][], R, C;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static Point dir[];
	static Queue<Point> queue = new LinkedList<Point>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		K = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
		}
		L = Integer.parseInt(in.readLine());
		dir = new Point[L];
		for (int i = 0; i < L ; i++) {
			st = new StringTokenizer(in.readLine());
			int time = Integer.parseInt(st.nextToken());
			int d = (st.nextToken().equals("D"))? 1 : -1;
			dir[i] = new Point(time, d);
		}//입력 끝
		int time = 0;
		int d = 1;
		int idx = 0;
		queue.add(new Point(0, 0));
		map[0][0] = 1;
		R = 0;
		C = 0;
		while(true) {
			time++;
			if(!move(d))
				break;
			if(idx < dir.length && time == dir[idx].x) {
				if(dir[idx].y == 1) {
					d = (d + 1) % 4;
				}else {
					d = (d - 1 < 0)? 3 : d-1;
				}
				idx++;
			}
		}
		System.out.println(time);
	}	
	private static boolean move(int d) {	
		int nr = R + dr[d];
		int nc = C + dc[d];
		if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1)//내 몸을 만나거나 범위 밖이면 아웃
			return false;
		if(map[nr][nc] != 2) {
			Point p = queue.poll();
			map[p.x][p.y] = 0;	
		}
		queue.add(new Point(nr, nc));
		map[nr][nc] = 1;
		R = nr;
		C = nc;
		return true;
	}
}
