package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj19237_어른상어_2회독 {
	static int N, M, k, ans, sharkCnt;
	static shark[] sharkList;

	static class shark {
		int num, r, c, d;
		boolean die = false;

		public shark(int num, int r, int c, int d) {
			this.num = num;
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "shark [num=" + num + ", r=" + r + ", c=" + c + ", d=" + d + ", die=" + die + "]";
		}

	}

	static class Node {
		int num, cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", cnt=" + cnt + "]";
		}

	}

	static Node[][] map;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int dir[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new Node[N][N];
		sharkList = new shark[M + 1];
		dir = new int[M + 1][4][4];
		ans = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num != 0)
					sharkList[num] = new shark(num, i, j, 0);
				map[i][j] = new Node(num, (num == 0) ? 0 : k); // 상어 냄새 표시 초기화
			}
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i < M + 1; i++) {
			int d = Integer.parseInt(st.nextToken()) - 1;
			sharkList[i].d = d;
		}
		for (int num = 1; num < M + 1; num++) {
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 4; j++) {
					dir[num][i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		} // 입력 끝
		sharkCnt = M;
		// t초동안 진행
		for (int t = 1; t <= 1000; t++) {
			move(t);// 상어 이동
			if (sharkCnt == 1) {
				ans = t;
				break;
			}
			del(t); // 냄새제거
		}
		System.out.println(ans);
	}

	private static void del(int t) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].num != 0 && map[i][j].cnt == t) {
					map[i][j].num = 0;
					map[i][j].cnt = 0;
				}
			}
		}
	}

	private static void move(int t) {
		int sharkMap[][] = new int[N][N];
		for (int i = 1; i < sharkList.length; i++) {
			if (!sharkList[i].die) {
				shark s = sharkList[i];
				int arr[] = dir[s.num][s.d];
				boolean flag = true;
				for (int j = 0; j < arr.length; j++) {
					int d = arr[j];
					int nr = s.r + dr[d];
					int nc = s.c + dc[d];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					// 아무 냄새가 없는 칸
					if (map[nr][nc].num == 0) {
						flag = false;
						if (sharkMap[nr][nc] == 0) { 
							sharkMap[nr][nc] = s.num;
						} else { //다른 상어가 이미 있다.
							if (sharkMap[nr][nc] < s.num) {
								sharkList[i].die = true;
							} else {
								sharkList[sharkMap[nr][nc]].die = true;
								sharkMap[nr][nc] = s.num;
							}
							sharkCnt--;
						}
						sharkList[i].r = nr;
						sharkList[i].c = nc;
						sharkList[i].d = d;
						break;
					}
				}
				if(flag) {
					//우선순위에 따라 자신의 냄새가 있는 칸 방향으로 설정
					for (int j = 0; j < arr.length; j++) {
						int d = arr[j];
						int nr = s.r + dr[d];
						int nc = s.c + dc[d];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;
						if(map[nr][nc].num == s.num) {
							sharkList[i].r = nr;
							sharkList[i].c = nc;
							sharkList[i].d = d;
							sharkMap[nr][nc] = s.num;
							break;
						}
					}
				}
			}
		}
		// 냄새뿌려
		for (int i = 1; i < sharkList.length; i++) {
			if (!sharkList[i].die) {
				shark s = sharkList[i];
				map[s.r][s.c].num = s.num;
				map[s.r][s.c].cnt = t + k;
			}
		}
	}
}
