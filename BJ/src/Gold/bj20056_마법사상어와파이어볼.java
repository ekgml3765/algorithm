package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20056_마법사상어와파이어볼 {

	static class Fireball {
		int r, c, m, s, d;
		boolean isOdd;
		boolean isHol;
		int cnt;

		public Fireball() {
		}

		public Fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.cnt = 1; // 파이어볼 생성시.
		}

	}

	static int N, M, K;
	static Queue<Fireball> queue;
	static List<Fireball> fireList;
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 파이어볼 갯수
		K = Integer.parseInt(st.nextToken());
		fireList = new ArrayList<Fireball>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireList.add(new Fireball(r, c, m, s, d));
		}

		for (int i = 0; i < K; i++) {
			// 이동위치 계산
			movedist();
			// 이동시켜
			move();
		}
		
		int ans = 0;
		for (int i = 0; i < fireList.size(); i++) {
			ans += fireList.get(i).m;
		}
		System.out.println(ans);

	}

	// 파이어볼 이동시켜
	private static void move() {
		Fireball[][] map = new Fireball[N][N]; // 맵 생성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new Fireball();
			}
		}

		// 범위밖 아웃
		while (!queue.isEmpty()) {
			Fireball fireball = queue.poll();
				
			// 맵에 넣어
			int r = fireball.r;
			int c = fireball.c;
			//빈칸
			if (map[r][c].cnt == 0) {
				map[r][c] = fireball;
				if(fireball.d % 2 == 0) {
					map[r][c].isOdd = true;
				}else {
					map[r][c].isHol = true;
				}
			} else {// 빈칸이 아니라 이미 있어.
				map[r][c].cnt += fireball.cnt;
				map[r][c].m += fireball.m; // 질량합
				map[r][c].s += fireball.s;// 속력합
				if (fireball.d % 2 == 0)
					map[r][c].isOdd = true;
				else
					map[r][c].isHol = true;
			}
		}

		// list생성
		fireList = new ArrayList<Fireball>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].cnt != 0) {
					if (map[i][j].cnt == 1) {
						if (map[i][j].m == 0)
							continue;
						fireList.add(map[i][j]);
					}

					else { // 여러개 합쳐진 상태
							// 4개로 나뉘어진다
						int m = map[i][j].m / 5;
						if (m == 0) // 질량이 0이면 리스트에 넣지마
							continue;
						int s = map[i][j].s / map[i][j].cnt;
						int r = i;
						int c = j;
						boolean flag = map[i][j].isOdd && map[i][j].isHol;
						if (flag) { // 둘다 TT면 true -> 섞여있다.
							for (int d = 1; d <= 7; d += 2) {
								fireList.add(new Fireball(r, c, m, s, d));
							}
						} else {// TF거나 FT면 False면 둘중 하나만 모두 홀수나 짝수다
							for (int d = 0; d <= 6; d += 2) {
								fireList.add(new Fireball(r, c, m, s, d));
							}
						}

					}

				}
			}
		}

	}

	// 이동위치 계산
	private static void movedist() {
		queue = new LinkedList<Fireball>();

		for (int i = 0; i < fireList.size(); i++) {
			Fireball fireball = fireList.get(i);
			int nr = fireball.r + (dr[fireball.d] * fireball.s);
			int nc = fireball.c + (dc[fireball.d] * fireball.s);
			fireball.r = nr;
			fireball.c = nc;
			//파이어볼 범위 계산. 파이어볼은 영원히 밖으로 나가지 않아.
			//음수일때
			if(fireball.r < 0)
				fireball.r = N - (Math.abs(nr) % N);
			if(fireball.c < 0)
				fireball.c = N - (Math.abs(nc) % N);
			//양수일떄
			if(fireball.r >= N)
				fireball.r = nr % N;
			if(fireball.c >= N)
				fireball.c = nc % N;
		
			queue.add(fireball);
		}

	}
}
