package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj21610_마법사상어와비바라기 {

	static int N, M;

	static class Baguni {
		boolean isCloud;
		int water;

		public Baguni(int water) {
			this.water = water;
		}
	}

	static Baguni map[][];
	static Point info[];
	static int dr[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int dc[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Baguni[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = new Baguni(Integer.parseInt(st.nextToken()));
			}
		} // end for

		info = new Point[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[i] = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}

		List<Point> cloudList = new ArrayList<Point>();
		cloudList.add(new Point(N - 1, 0));
		cloudList.add(new Point(N - 1, 1));
		cloudList.add(new Point(N - 2, 0));
		cloudList.add(new Point(N - 2, 1));

		for (int i = 0; i < M; i++) {
			move(cloudList, info[i]);
			cloudList = make(cloudList);
		}
		// 구름 리스트 M합 구하기
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += map[i][j].water;
			}
		}
		System.out.println(ans);
	}

	private static List<Point> make(List<Point> cloudList) {

		List<Point> newCloudList = new ArrayList<Point>();
		//새로운 리스트 만들어서 반환
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].isCloud) {
					map[i][j].isCloud = false;
					continue;
				}
				if(!map[i][j].isCloud && map[i][j].water >= 2) {
					newCloudList.add(new Point(i, j));
					map[i][j].water -= 2;
				}
			}
		}
		
		return newCloudList;
	}

	static int ddr[] = {-1, -1, 1, 1};
	static int ddc[] = {-1, 1, 1, -1};
	private static void move(List<Point> cloudList, Point point) {
		int d = point.x;
		int s = point.y;
		//구름 이동
		for (int i = 0; i < cloudList.size(); i++) {
			int nr = cloudList.get(i).x + (dr[d] * s);
			int nc = cloudList.get(i).y + (dc[d] * s);		
			nr = nr % N;
			nc = nc % N;
			if(nr < 0) {
				nr = N - Math.abs(nr);
			}
			if(nc < 0) {
				nc = N - Math.abs(nc);
			}
			cloudList.get(i).x = nr;
			cloudList.get(i).y = nc;
			map[nr][nc].isCloud = true;
			map[nr][nc].water++;
		}
		//대각선 체크
		for (int i = 0; i <cloudList.size(); i++) {
			int r = cloudList.get(i).x;
			int c = cloudList.get(i).y;
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				int nr = r + ddr[j];
				int nc = c + ddc[j];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc].water == 0) continue;
				cnt++;
			}
			map[r][c].water += cnt;
		}
	}
}
