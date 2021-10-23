package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj19236_청소년상어 {
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static class fish implements Comparable<fish> {
		int num, r, c, d;

		public fish(int num, int r, int c, int d) {
			this.num = num;
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "fish [num=" + num + ", r=" + r + ", c=" + c + ", d=" + d + "]";
		}

		@Override
		public int compareTo(fish o) {
			return this.num - o.num;
		}

	}

	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int map[][] = new int[4][4];
		fish[] fishList = new fish[17];
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = num;
				fishList[num] = new fish(num, i, j, d);
				idx++;
			}
		} // 입력 끝
		// 상어초기화
		int eatnum = map[0][0];
		int sharkD = fishList[map[0][0]].d;
		fishList[map[0][0]] = null;
		map[0][0] = 17;
		// 물고기 이동
		movefish(map, fishList);
		shark(0, 0, sharkD, map, fishList, eatnum);
		System.out.println(max);
	}

	private static void shark(int r, int c, int d, int[][] map, fish[] fishList, int sum) {
		List<Point> sharkList = new ArrayList<>();
		int nr = r;
		int nc = c;
		for (int i = 0; i < 3; i++) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4 )
				break;
			if(map[nr][nc] == 0)
				continue;
			sharkList.add(new Point(nr, nc));
		}
		if (sharkList.size() == 0) {
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < sharkList.size(); i++) {
			int copyMap[][] = new int[4][4];
			fish copyfish[] = new fish[17];
			for (int k = 0; k < copyMap.length; k++) {
				copyMap[k] = map[k].clone();
			}
			for (int k = 1; k < copyfish.length; k++) {
				if(fishList[k] == null)
					continue;
				copyfish[k] = new fish(fishList[k].num, fishList[k].r, fishList[k].c, fishList[k].d);
			}
			Point p = sharkList.get(i);
			int eat = copyMap[p.x][p.y];
			int nd = copyfish[eat].d;
			copyfish[eat] = null;
			copyMap[r][c] = 0;
			copyMap[p.x][p.y] = 17;
			movefish(copyMap, copyfish);
			shark(p.x, p.y, nd, copyMap, copyfish, sum + eat);
		}

	}

	private static void movefish(int[][] map, fish[] fishList) {
		for (int i = 1; i < fishList.length; i++) {
			if (fishList[i] != null) {
				fish f = fishList[i];
				for (int d = 0; d < 8; d++) {
					int nr = f.r + dr[f.d];
					int nc = f.c + dc[f.d];
					if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4 || map[nr][nc] == 17) {
						f.d = (f.d + 1) % 8;
						continue;
					}
					// 빈칸
					if (map[nr][nc] == 0) {
						map[f.r][f.c] = 0;
						map[nr][nc] = f.num;
						f.r = nr;
						f.c = nc;
					} else {// 다른 물고기
						fish a = fishList[map[nr][nc]];
						a.r = f.r;
						a.c = f.c;
						map[f.r][f.c] = a.num;
						map[nr][nc] = f.num;
						f.r = nr;
						f.c = nc;
						fishList[a.num] = a;
					}
					break;
				}
				// 다시 세팅
				fishList[i] = f;
			}
		}
	}
}
