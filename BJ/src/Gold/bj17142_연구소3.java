package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17142_연구소3 {

	static int N, M, map[][], size, cnt, testmap[][], num, ans, time;
	static List<birus> birusList;
	static List<birus> movebirusList;
	static boolean visit[][], flag;
	static birus[] sel;

	static class birus {
		int r, c, time;

		public birus(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		birusList = new ArrayList<birus>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
		
				if (map[i][j] == 2) { // 바이러스 -2로 바꿔
					birusList.add(new birus(i, j, 0)); // 바이러스 위치담아
					map[i][j] = -2;
				}
				if (map[i][j] == 1) { // 벽 -1로 바꿔
					map[i][j] = -1;
				}
			}
		}

		size = birusList.size();
		sel = new birus[M];
		ans = Integer.MAX_VALUE;
		flag = false;
		comb(0, 0);

		ans = (flag==true)? ans : -1;
		System.out.println(ans);

	}

	// M개뽑아 조합
	private static void comb(int idx, int s_idx) {

		if (s_idx == M) {
			// 맵복사
			testmap = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					testmap[i][j] = map[i][j];
				}
			}
			//활성화된 바이러스 -3으로 바꿔
			for (int i = 0; i < sel.length; i++) {
				birus b = sel[i];
				testmap[b.r][b.c] = -3;
			}

			movebirusList = new ArrayList<birus>();
			num = 0; // 0의 갯수 초기화해서 받음
			time = 0; // bfs돌리기전 타임 초기화
			visit = new boolean[N][N];
			for (int i = 0; i < sel.length; i++) {
				birus b = sel[i];
				// bfs퍼트려
				bfs(b);
			}
			
			//비활성화된 애가 활성화가 되면. 다시 bfs 돌려
			if(movebirusList.size() !=0) {
				for (int i = 0; i < movebirusList.size(); i++) {
					birus b = movebirusList.get(i);
					bfs(b);
				}
			}
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < N; j++) {
					time = Math.max(testmap[i][j], time);
					if(testmap[i][j] == 0) num++;
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(testmap[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			// 바이러스가 다 퍼졌다? -> num == 0 빈칸이 없다.
			if (num == 0) {
				flag = true;
				ans = Math.min(time, ans);
			}
			return;
		}

		if (idx == size) {
			return;
		}

		sel[s_idx] = birusList.get(idx);
		comb(idx + 1, s_idx + 1);
		comb(idx + 1, s_idx);

	}

	// 바이러스 퍼트리기
	private static void bfs(birus b) {
		Queue<birus> queue = new LinkedList<birus>();
		queue.add(b);
		visit[b.r][b.c] = true;

		while (!queue.isEmpty()) {
			birus br = queue.poll();
			
			for (int d = 0; d < 4; d++) {

				int nr = br.r + dr[d];
				int nc = br.c + dc[d];

				// 범위밖
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				
				//방문 안했고 비활성화 바이러스 만났어. 
				if(testmap[nr][nc] == -2 && !visit[nr][nc])
					movebirusList.add(new birus(nr, nc, br.time+1));
				// 양수 아니면 재껴
				if (testmap[nr][nc] < 0)
					continue;
				
				//방문은 했는데, 내가 퍼지려는 시간보다 값이 더 크면 바꾸고,
				//방문을 아예 안했으면
				if((visit[nr][nc] && (testmap[nr][nc] > br.time+1) )||
						!visit[nr][nc]) {
					// 바이러스 퍼트림
					testmap[nr][nc] = br.time + 1;
					visit[nr][nc] = true;
					queue.add(new birus(nr, nc, br.time + 1));
				}
			}
		}

	}
}
