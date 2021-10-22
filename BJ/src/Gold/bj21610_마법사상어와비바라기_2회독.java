package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj21610_마법사상어와비바라기_2회독 {

	static int N, M, map[][], info[][], sum = 0;
	static boolean visit[][];
	static int dr[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int dc[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static List<Point> cloudList;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		info = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			info[i][0] = Integer.parseInt(st.nextToken()) - 1;
			info[i][1] = Integer.parseInt(st.nextToken());
		} // 입력끝
		cloudList = new ArrayList<Point>();
		cloudList.add(new Point(N - 1, 0));
		cloudList.add(new Point(N - 1, 1));
		cloudList.add(new Point(N - 2, 0));
		cloudList.add(new Point(N - 2, 1));
		// M번반복
		for (int i = 0; i < M; i++) {
			move(info[i][0], info[i][1]); // 구름이동
			water(); // 이동한 곳 물 증가
			copy(); // 물 복사 버그
			cloud();// 구름새로 생겨
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}

	private static void cloud() {
		List<Point> newCloudList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2 && !visit[i][j]) {
					newCloudList.add(new Point(i, j));
					map[i][j] -= 2;
				}
			}
		}
		cloudList = newCloudList;
	}

	private static void copy() {
		visit = new boolean[N][N];
		for (int i = 0; i < cloudList.size(); i++) {
			Point p = cloudList.get(i);
			int cnt = 0;
			for (int d = 1; d <= 7; d += 2) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0)
					continue;
				cnt++;
			}
			map[p.x][p.y] += cnt;
			visit[p.x][p.y] = true;
		}
	}

	private static void water() {
		for (Point p : cloudList) {
			map[p.x][p.y]++;
		}
	}

	private static void move(int d, int s) {
		for (int i = 0; i < cloudList.size(); i++) {
			Point p = cloudList.get(i);
			int nr = p.x + (dr[d] * s);
			int nc = p.y + (dc[d] * s);
			nr = (nr >= 0) ? nr % N : (N - (-nr % N)) % N;
			nc = (nc >= 0) ? nc % N : (N - (-nc % N)) % N;
			p.x = nr;
			p.y = nc;
			cloudList.set(i, p);
		}
	}
}
