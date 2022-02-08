package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16458_가장큰숫자 {
	static int N, M;
	static char[][] map;
	static int ans = 0;
	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		boolean visit[][] = new boolean[N][M];
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '*' && !visit[i][j]) {
					int num = 0;
					int cnt = 0;
					visit[i][j] = true;
					int R = i;
					int k = 1;
					Queue<Point> queue = new LinkedList<Point>();
					queue.add(new Point(i,j));
					while(!queue.isEmpty()) {
						Point p = queue.poll();
						R = Math.max(p.x, R);
						cnt++;
						for (int d = 0; d < 8; d++) {
							int nr = p.x + dr[d];
							int nc = p.y + dc[d];
							if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] == ' ')
								continue;
							visit[nr][nc] = true;
							queue.add(new Point(nr, nc));
						}
					}
					k = (R-i+1)/5;
					int rem = (3*k*5*k) - cnt;
					rem /= (k*k);
					switch(rem) {
					case 2:{
						num = 8;
						break;
					}
					case 3:{
						num = 0;
						break;
					}
					case 5:{
						if(map[i+k][j] == ' ')
							num = 3;
						else if(map[i+(5*k)-1][j] == ' ') {
							num = 9;
						}else if(map[i][j+k] == ' ') {
							num = 6;
						}else {
							num = 5;
						}
						break;
					}
					case 6:{
						num = 4;
						break;
					}
					case 7:{
						int nr = i + dr[3]*k;
						int nc = j + dc[3]*k;
						if(map[nr][nc] == '*')
							num = 1;
						else
							num = 2;
						break;
					}
					case 8:{
						num = 7;
						break;
					}
					}
					
					if(k >= max) {
						max = k;
						ans = num;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
