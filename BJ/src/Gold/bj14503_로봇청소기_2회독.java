package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14503_로봇청소기_2회독 {
	static int N, M, map[][], ans = 0, R, C, D;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(ans);
	}
	private static void solve() {
		boolean flag = true;
		out: while(true) {
			//1번 현재 위치를 청소한다
			if(flag) {
				map[R][C] = 2;
				ans++;
			}
			//2번
			int cnt = 0;
			flag = true;
			for (int i = 0; i < 4; i++) {
				int nd = (D-1 < 0)? 3 : D-1;
				int nr = R + dr[nd];
				int nc = C + dc[nd];
				if(map[nr][nc] == 0) {
					D = nd;
					R = nr;
					C = nc;
					break;
				}else {
					//청소할 공간이 없다 = 벽이거나 이미 청소했거나.
					D = nd;
					cnt++;
				}
			}
			if(cnt == 4) {
				int nr = R-dr[D];
				int nc = C-dc[D];
				if(map[nr][nc] == 1)
					break out;
				R = nr;
				C = nc;
				flag = false;
			}
		}
	}
}
