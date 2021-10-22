package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj21611_마법사상어와블리자드_2회독 {
	static int N, M, map[][], ans[], info[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int ddr[] = { 0, 1, 0, -1 };
	static int ddc[] = { -1, 0, 1, 0 };
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[3];
		map = new int[N][N];
		info = new int[M][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			info[i][0] = Integer.parseInt(st.nextToken()) - 1; // d
			info[i][1] = Integer.parseInt(st.nextToken()); // s
		} // 입력 끝

		// 블리자드 M번 시행
		for (int i = 0; i < M; i++) {
			// 얼음파편 - 맵에서 파괴
			ice(info[i][0], info[i][1]);
			// 구슬 이동- 일차원
			makeList();
			// 구슬 폭파 - 구슬 수 세
			bomb();
			// 구슬 변화 - 다시 맵에 깔아
			change();
			goList();
		}
		// 1번상어폭발, 2번상어폭발, 3번상어 폭발
		int sum = 0;
		for (int i = 0; i < ans.length; i++) {
			sum += (ans[i] * (i + 1));
		}
		System.out.println(sum);
	}
	private static void goList() {
		map = new int[N][N];
		int nr = N / 2;
		int nc = N / 2;
		int odd = 1;
		int even = 2;
		int idx = 0;
		out: while (true) {
			for (int d = 0; d < 4; d++) {
				if (d < 2) {
					for (int i = 0; i < odd; i++) {
						if (idx >= list.size() || idx >= (N*N)-1)
							break out;
						nr += ddr[d];
						nc += ddc[d];
						map[nr][nc] = list.get(idx);
						idx++;
					}
				} else {
					for (int i = 0; i < even; i++) {
						if (idx >= list.size() || idx >= (N*N)-1)
							break out;
						nr += ddr[d];
						nc += ddc[d];
						map[nr][nc] = list.get(idx);
						idx++;
					}
				}
			}
			odd += 2;
			even += 2;
		}
	}
	private static void change() {
		List<Integer> newList = new ArrayList<Integer>();
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int key = 0;
		for (int i = 0; i < list.size(); i++) {
			int num = list.get(i);
			if (hash.size() == 0) {
				hash.put(num, 1);
				key = num;
			} else {
				if (!hash.containsKey(num)) {
					newList.add(hash.get(key));
					newList.add(key);
					hash.remove(key);
					key = num;
					hash.put(key, 1);
				} else {
					hash.put(num, hash.getOrDefault(num, 0)+1);
				}
			}
		}
		for (Integer k : hash.keySet()) {
			newList.add(hash.get(k));
			newList.add(k);
		}
		list = newList;
		
	}

	private static void bomb() {
		boolean flag = false;
		List<Integer> newList = new ArrayList<Integer>();
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int key = 0;
		for (int i = 0; i < list.size(); i++) {
			int num = list.get(i);
			if (hash.size() == 0) {
				hash.put(num, 1);
				key = num;
			} else {
				if (!hash.containsKey(num)) {
					int cnt = hash.get(key);
					if (cnt < 4) {
						for (int j = 0; j < hash.get(key); j++) {
							newList.add(key);
						}
					}else {
						ans[key-1] += cnt;
					}
					hash.remove(key);
					key = num;
					hash.put(key, 1);
				} else {
					hash.put(num, hash.getOrDefault(num, 0)+1);
				}
			}
		}
		for (Integer k : hash.keySet()) {
			if (hash.get(k) < 4) {
				for (int i = 0; i < hash.get(k); i++) {
					newList.add(k);
				}
			}else {
				ans[key-1] += hash.get(k);
			}
		}
		
		if(list.size() != newList.size()) {
			list = newList;
			bomb();
		}
	}

	private static void makeList() {
		list = new ArrayList<>();
		int cnt = 1;
		int nr = N / 2;
		int nc = N / 2;
		int odd = 1;
		int even = 2;
		out: while (true) {
			for (int d = 0; d < 4; d++) {
				if (d < 2) {
					for (int i = 0; i < odd; i++) {
						if (cnt >= N * N)
							break out;
						nr += ddr[d];
						nc += ddc[d];
						if (map[nr][nc] != 0)
							list.add(map[nr][nc]);
						cnt++;
					}
				} else {
					for (int i = 0; i < even; i++) {
						if (cnt >= N * N)
							break out;
						nr += ddr[d];
						nc += ddc[d];
						if (map[nr][nc] != 0)
							list.add(map[nr][nc]);
						cnt++;
					}
				}
			}
			odd += 2;
			even += 2;
		}
	}

	private static void ice(int d, int s) {
		int nr = N / 2;
		int nc = N / 2;
		for (int i = 0; i < s; i++) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				break;
			map[nr][nc] = 0;
		}
	}
}
