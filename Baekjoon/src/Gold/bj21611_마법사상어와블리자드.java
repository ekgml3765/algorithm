package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj21611_마법사상어와블리자드 {

	static int N, M, map[][];
	static Point[] info;
	static int ans1Cnt = 0, ans2Cnt = 0, ans3Cnt = 0;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		info = new Point[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			info[i] = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));

		} // 입력끝

		// M만큼 시전
		for (int i = 0; i < M; i++) {
			ice(info[i].x, info[i].y);
			eat();
			pop();
			if(list.size()!=0)
				put();
		}
		System.out.println(ans1Cnt + (2 * ans2Cnt) + (3 * ans3Cnt));
	}

	private static void put() {

		// 그룹을 만들어서 list 생성 후
		List<Integer> newList = new ArrayList<Integer>();
		int B = list.get(0); // 어떤 숫자의 구슬인지
		int A = 1;
		for (int i = 1; i < list.size(); i++) {
			if (B == list.get(i)) {
				A++;
				if (i == list.size() - 1) {
					newList.add(A);
					newList.add(B);
				}
			} else {
				newList.add(A);
				newList.add(B);
				B = list.get(i);
				A = 1;
				if (i == list.size() - 1) {
					newList.add(A);
					newList.add(B);
				}
			}
		}

		int r = N / 2;
		int c = N / 2;
		int newMap[][] = new int[N][N];
		int cnt = 1;
		int hol = 1;
		int odd = 2;
		int nr = r;
		int nc = c;
		int idx = 0;
		int size = newList.size();
		out: while (idx < N * N - 1 && idx < size) {
			for (int d = 0; d < 4; d++) {
				if (d == 0 || d == 1) {
					for (int i = 0; i < hol; i++) {
						//newList size 작을때
						if (idx >= N * N - 1 || idx >= size)
							break out;
						nr = nr + dr[d];
						nc = nc + dc[d];
						newMap[nr][nc] = newList.get(idx);
						idx++;
					}
				}
				if (d == 2 || d == 3) {
					for (int i = 0; i < odd; i++) {
						if (idx >= N * N - 1 || idx >= size)
							break out;
						nr = nr + dr[d];
						nc = nc + dc[d];
						newMap[nr][nc] = newList.get(idx);
						idx++;
					}
				}
			} // end for
			hol += 2;
			odd += 2;
		}

		for (int i = 0; i < N; i++) {
			map[i] = newMap[i].clone();
		}

	}

	// 구슬 폭파
	private static void pop() {
		// 연속된 구슬이 4이상이 있을 때 까지 반복
		while (true) {
			boolean flag = false;
			for (int i = 0; i < list.size(); i++) {
				int number = list.get(i);
				if (number == 0)
					continue;
				int cnt = 1;
				int idx = i + 1;
				while (idx < list.size()) {
					if (number != list.get(idx))
						break;
					else
						cnt++;
					idx++;
				}
				// 체크
				if (cnt >= 4) {
					// 0으로 바꾸기
					for (int j = i; j < i + cnt; j++) {
						list.set(j, 0);
					}
					// 폭발한 구슬 ++
					if (number == 1)
						ans1Cnt += cnt;
					if (number == 2)
						ans2Cnt += cnt;
					if (number == 3)
						ans3Cnt += cnt;
					flag = true;
				}
			} // end for
			if (!flag)
				break;
			else {
				// 리스트 새로 생성
				List<Integer> newList = new ArrayList<Integer>();
				for (Integer integer : list) {
					if (integer != 0)
						newList.add(integer);
				}
				list = newList;
			}
		}
	}

	static int ddr[] = { -1, 1, 0, 0 };
	static int ddc[] = { 0, 0, -1, 1 };

	// 얼음파편
	private static void ice(int d, int s) {
		int r = N / 2;
		int c = N / 2;
		int nr = r;
		int nc = c;
		while (s != 0) {
			nr = nr + ddr[d];
			nc = nc + ddc[d];
			map[nr][nc] = 0;
			s--;
		}
	}

	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { -1, 0, 1, 0 };

	// 구슬 먹기
	private static void eat() {

		list = new ArrayList<Integer>();
		int r = N / 2;
		int c = N / 2;
		int cnt = 1;
		int hol = 1;
		int odd = 2;
		int nr = r;
		int nc = c;
		// 구슬 먹기
		out: while (cnt <= N * N - 1) {
			for (int d = 0; d < 4; d++) {
				if (d == 0 || d == 1) {
					for (int i = 0; i < hol; i++) {
						if (cnt > N * N - 1)
							break out;
						nr = nr + dr[d];
						nc = nc + dc[d];
						if (map[nr][nc] != 0)
							list.add(map[nr][nc]);
						cnt++;
					}
				}
				if (d == 2 || d == 3) {
					for (int i = 0; i < odd; i++) {
						if (cnt > N * N - 1)
							break out;
						nr = nr + dr[d];
						nc = nc + dc[d];
						if (map[nr][nc] != 0)
							list.add(map[nr][nc]);
						cnt++;
					}
				}
			} // end for
			hol += 2;
			odd += 2;
		}
	}
}
