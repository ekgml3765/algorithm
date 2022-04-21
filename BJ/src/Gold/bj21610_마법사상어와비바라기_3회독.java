package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj21610_마법사상어와비바라기_3회독 {

	static int N, M, map[][], check[][], dir, s;
	static List<Point> cloudList;
	static int dr[] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int dc[] = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int ddr[] = {-1, 1, 1, -1};
	static int ddc[] = {1, 1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cloudList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			dir = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			if(i == 0) {
				cloudList.add(new Point(N-1, 0));
				cloudList.add(new Point(N-1, 1));
				cloudList.add(new Point(N-2, 0));
				cloudList.add(new Point(N-2, 1));
			}
			//이동
			move(dir, s);	
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans);
	}
	private static void move(int dir, int s) {
		check = new int [N][N];
		for (int i = 0; i < cloudList.size(); i++) {
			Point node = cloudList.get(i);
			int nr = (N + ((node.x + dr[dir]*s) % N)) % N;
			int nc = (N + ((node.y + dc[dir]*s) % N)) % N;
			node.x = nr;
			node.y = nc;
			cloudList.set(i, node);
			check[nr][nc] = 1;
			map[nr][nc]++;
		}
		//물복사 버그
		for (int i = 0; i < cloudList.size(); i++) {
			Point node = cloudList.get(i);
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = node.x + ddr[d];
				int nc = node.y + ddc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0)
					continue;
				cnt++;
			}
			map[node.x][node.y] += cnt;	
		}
		//새로운 구름
		cloudList.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] >= 2 && check[i][j] != 1) {
					map[i][j]-=2;
					cloudList.add(new Point(i, j));
				}
			}
		}
	}
}