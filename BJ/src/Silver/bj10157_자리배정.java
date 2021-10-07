package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10157_자리배정 {

	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(in.readLine());
		int map[][] = new int[R][C];
		if(num > R*C) {
			System.out.println(0);
		}else {
			int cnt = 1;
			int r = R-1;
			int c = 0;
			int d = 0;
			while(cnt <= R*C) {
				map[r][c] = cnt;
				if(cnt == num) {
					r = R - r;
					c = c + 1;
					break;
				}
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] > 0) {
					d = (d+1)%4;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				r = nr;
				c = nc;
				cnt++;
			}
			System.out.println(c + " " + r);
		}		
	}
}
