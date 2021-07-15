package Gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19237_어른상어 {

	static class Status{
		int num, smell;
		
		public Status() {}
		public Status(int num, int smell) {
			this.num = num;
			this.smell = smell;
		}
		
	}
	static class Shark{
		int r, c, dir;
		boolean isdead;

		public Shark(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	static int N, M, k, time, sharkCnt;
	static int testmap[][], sharkDir[][][];
	static Shark sharkList[];
	static Status map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		testmap = new int [N][N];
		sharkList = new Shark[M+1];
		sharkDir = new int[M+1][4][4]; //M번쨰 상어의 현재방향이 j방향일떄 우선순위
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				testmap[i][j] = Integer.parseInt(st.nextToken());
				if(testmap[i][j] != 0) {
					sharkList[testmap[i][j]] = new Shark(i, j, 0);
				}
			}
		}
		st = new StringTokenizer(in.readLine());
		//상어 기본방향 설정
		for (int i = 1; i <= M; i++) {
			sharkList[i].dir = Integer.parseInt(st.nextToken())-1; //방향 -1
		}
		
		//상어별 방향리스트
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < 4; k++) {
					sharkDir[i][j][k] = Integer.parseInt(st.nextToken())-1; //방향 -1
				}
			}
		}//end for
		//맵 초기세팅
		map = new Status[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new Status();
			}
		}
		for (int i = 1; i < sharkList.length; i++) {		
			map[sharkList[i].r][sharkList[i].c].num = i;
			map[sharkList[i].r][sharkList[i].c].smell = k;
		}
		
		sharkCnt = M;
		time = 0;
		while(true) {
			//이동할 위치 정하기
			dist();
			//냄새지워
			delSmell();
			//이동시켜
			move();
			//시간++
			time++;
			if(sharkCnt == 1 || time > 1000) //시간이 1000넘거나 1번상어만 남으면
				break;
		}
		
		//시간이 1001이되면 -1출력
		time = (time>1000)? -1 : time;
		System.out.println(time);
		System.out.println();
	
	}
	
	//상어 이동
	private static void move() {
	
		boolean visit[][] = new boolean[N][N];
		for (int i = 1; i <= M; i++) {
			if(!sharkList[i].isdead) {//죽은 상어가 아니라면 옮겨
				int r = sharkList[i].r;
				int c = sharkList[i].c;
				if(visit[r][c]) { //이미 방문했으면 숫자 작은 상어가 이미 방문함.
					sharkCnt --;
					sharkList[i].isdead = true; //상어 죽임
					continue;
				}
				visit[r][c] = true; //방문체크
				map[r][c].num = i;
				map[r][c].smell = k;
			}
		}
		
	}

	//냄새 지워
	private static void delSmell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].smell != 0) {
					map[i][j].smell --;
					if(map[i][j].smell == 0 ) //냄새가 0이면 상어자국도 0
						map[i][j].num = 0;
				}
					
			}
		}
		
	}

	//이동할 위치 찾아
	private static void dist() {
		for (int i = 1; i <= M; i++) {
			//죽은 상어가 아니라면
			if(!sharkList[i].isdead) {
				//빈칸인지 찾아
				int curDir = sharkList[i].dir;
				int r = sharkList[i].r;
				int c = sharkList[i].c;
				boolean flag = true;
				for (int d = 0; d < 4; d++) {
					int dir = sharkDir[i][curDir][d];
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					//범위밖 아웃
					if(nr < 0 || nc < 0 || nr >= N || nc >= N ) continue;
					
					//빈칸이면
					if(map[nr][nc].smell == 0) {
						flag = false;
						sharkList[i].r = nr;
						sharkList[i].c = nc;
						sharkList[i].dir = dir; //방향도 바꿔줘
						break;
					}
				}
				
				//빈칸이 없다면 자기가 온 방향에서 찾아야함
				if(flag) { 
					for (int d = 0; d < 4; d++) {
						int dir = sharkDir[i][curDir][d];
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						//범위밖 아웃
						if(nr < 0 || nc < 0 || nr >= N || nc >= N ) continue;
						//내가 온 방향이다
						if(map[nr][nc].num == i) {
							sharkList[i].r = nr;
							sharkList[i].c = nc;
							sharkList[i].dir = dir; //방향도 바꿔줘
							break;
						}
					}	
				}
			}
		}
		
	}
}
