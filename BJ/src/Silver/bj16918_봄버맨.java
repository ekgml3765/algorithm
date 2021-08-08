package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16918_봄버맨 {

	static int R, C, N;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static class bomb{
		char c;
		int endtime;
		public bomb(char c, int endtime) {
			this.c = c;
			this.endtime = endtime;
		}		
	}
	static bomb map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new bomb[R][C];
		for (int i = 0; i < R; i++) {
			String s = in.readLine();
			for (int j = 0; j < C; j++) {
				char c = s.charAt(j);
				int endtime = (c=='.')? -1:3;
				map[i][j] = new bomb(c, endtime);
			}
		}//입력 끝
		
		int time = 1;
		while(time <= N) {
			pop(time);
			time++;
			if(time > N)
				break;
			add(time);
			time++;
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j].c);
			}
			System.out.println();
		}
	}
	
	private static void add(int time) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j].c == '.') {
					map[i][j].c = 'O';
					map[i][j].endtime = time+3;
				}
			}
		}
	}

	private static void pop(int time) {
		boolean visit[][] = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j].c == 'O' && map[i][j].endtime == time) {
					map[i][j].c = '.';
					visit[i][j] = true;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr >= 0 && nc >= 0 && nr < R && nc < C && !visit[nr][nc] && map[nr][nc].endtime != map[i][j].endtime) {
							visit[nr][nc] = true;
							map[nr][nc].c = '.';
						}
					}
				}
			}
		}
	}
}
