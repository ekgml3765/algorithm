package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16236_아기상어 {
	
	static int N, map[][], time, shark_size, shark_r, shark_c, fishCnt;
	static boolean flag;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static List<Fish> fishList;
	static class Fish{
		int r, c, cnt;
		boolean arrive;
		public Fish() {}
		public Fish(int r, int c, int cnt, boolean arrive) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.arrive = arrive;
		}
	}
	static class Shark{
		int r, c, cnt;

		public Shark(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		map = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark_size = 2;
					shark_r = i;
					shark_c = j;
					//상어자리 리셋
					map[i][j] = 0;
				}
			}
		}//end for 입력
		
		fishCnt = 0;
		time = 0;
		flag = false; //더이상 먹을 물고기가 없다
		while(true) {
			//먹을 수 있는 물고기 찾아
			fishList = new ArrayList<Fish> ();
			findfish();
			if(fishList.size() == 0) //먹을 물고기가 없다면
				break;
			eatingfish();
			if(flag) //먹을 물고기는 있는데 이동 불가
				break;
		}

		System.out.println(time);

		
	}
	
	//먹을 물고기 찾아
	private static void findfish() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0 && map[i][j] < shark_size) {
					fishList.add(new Fish(i, j, 0, false));
				}
			}
		}
	}
	
	private static void eatingfish() {
		//bfs돌려
		for (int i = 0; i < fishList.size(); i++) {
			bfs(fishList.get(i), i);
		}
		//리스트 결과를 보고 1마리 물고기 찾아
		boolean noFish = true;
		
		int min = Integer.MAX_VALUE;
		int r = N-1;
		int c = N-1;

		for (int i = 0; i < fishList.size(); i++) {
			Fish f = fishList.get(i);
			if(f.arrive == true) { //상어가 갈 수있다면
				noFish = false;
				//최단 거리가 같거나 작다
				if(f.cnt <= min) {
					if( f.cnt == min) { //최단거리가 같다
						if(f.r <= r) { //더 아래에 있는 행
							if(f.r == r) {//열비교해야함
								if(f.c < c) { //같행 더 작은 열
									min = f.cnt;
									r = f.r;
									c = f.c;
								}
								//그게 아니라면 바꿀필요 ㄴㄴ
							}
							else {//더 위에있다면 바꿔줘
								min = f.cnt;
								r = f.r;
								c = f.c;
							}
							
						}
						//기존 물고기 보다 더 아래행에있다
					}
					else {//현재 물고기 최단거리가 더 작다면 바꿔
						min = f.cnt;
						r = f.r;
						c = f.c;
					}
				}
			}	
		}
		
		//먹을 물고기는 있지만 이동불가라 못먹음
		if(noFish) {
			flag = true;
			return;
		}
		//물고기 먹으러가, 물고기자리 리셋. 상어위치변경, 이동시간 더해, 물고기 갯수 카운트
		map[r][c] = 0;
		shark_r = r;
		shark_c = c;
		time += min;
		fishCnt++;
		
		//물고기 갯수와 상어 사이즈가 같다면
		if(fishCnt == shark_size) {
			//상어 사이즈 키워, 상어 사이즈 키우면 갯수 초기화
			shark_size++;
			fishCnt = 0;
		}
			
	}

	private static void bfs(Fish fish, int idx) {
		boolean visit[][] = new boolean [N][N];
		Queue<Shark> queue = new LinkedList<Shark>();
		queue.add(new Shark(shark_r, shark_c, 0));
		visit[shark_r][shark_c] = true;
		
		while(!queue.isEmpty()) {
			Shark s = queue.poll();
			if(s.r == fish.r && s.c == fish.c) {//상어가 이 위치에 도달했다
			Fish f = new Fish(s.r, s.c, s.cnt, true);
			fishList.set(idx, f);
			return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = s.r + dr[d];
				int nc = s.c + dc[d];
				//범위밖
				if( nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				//방문한거면 ㄴㄴ
				if(visit[nr][nc]) continue;
				//상어 사이즈보다 크면 못지나가
				if(shark_size < map[nr][nc]) continue; 
				
				visit[nr][nc] = true;
				queue.add(new Shark(nr, nc, s.cnt + 1));
			}
		}
	}
		
}
