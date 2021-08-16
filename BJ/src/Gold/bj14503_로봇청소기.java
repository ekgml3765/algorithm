package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14503_로봇청소기 {

	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int [N][M];
		boolean check[][] = new boolean[N][M];
		st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		boolean flag = true;
		out: while(true) {
			if(flag) {
				check[R][C] = true;
				cnt++;
			}
			flag = true;
			for (int i = 0; i < 4; i++) {
				d = (d-1 < 0)? 3 : d-1;
				int nr = R + dr[d];
				int nc = C + dc[d];
				if(check[nr][nc] || map[nr][nc] == 1)
					continue;
				R = nr;
				C = nc;
				continue out;
			}
			int nr = R-dr[d];
			int nc = C-dc[d];
			if(map[nr][nc] == 1)
				break;
			R = nr;
			C = nc;
			flag = false;
		}
		System.out.println(cnt);
	}
}
