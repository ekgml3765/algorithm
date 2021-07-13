package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17143_낚시왕 {

	static int R, C, M;
	static int map[][];
	static class Shark{
		int r, c, s, d, z;
		boolean isdead;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
	}
	static Shark[] sharkList;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, 1, -1}; //상 하 우 좌
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		sharkList = new Shark[M+1];
		
		if(M==0) {
			System.out.println(0);
			return;
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) -1 ;
			int c = Integer.parseInt(st.nextToken()) -1 ;
			int s = Integer.parseInt(st.nextToken());//속력
			int d = Integer.parseInt(st.nextToken()) -1;
			int z = Integer.parseInt(st.nextToken()); //크기
			sharkList[i] = new Shark(r, c, s, d, z); // 1번쨰 상어부터 쭉~
		}
		//상어 초기화
		for (int i = 1; i <= M; i++) {
			map[sharkList[i].r][sharkList[i].c] = i;
		}
		//열만큼 반복
		int ans = 0;
		for (int j = 0; j < C; j++) {
			//해당 열 상어 잡아
			for (int i = 0; i < R; i++) {
				if(map[i][j] != 0) {
					int num = map[i][j]; //해당 번호 상어 먹어
					ans+= sharkList[num].z;
					sharkList[num].isdead = true; //해당 상어는 죽음
					//죽은 상어 자리 초기화
					map[i][j] = 0;
					break;
				}
			}
			//상어 이동
			move();
		}
		
		System.out.println(ans);
	}
	
	//상어 이동
	private static void move() {
		
		//모든 상어에 대해서 이동시킬 위치를 정해
		for (int i = 1; i <= M; i++) {
			if(!sharkList[i].isdead) { //죽지 않은 상어들 이동할 위치 담아
				//해당 방향으로 해당 속도만큼 가.
				int nr = sharkList[i].r;
				int nc = sharkList[i].c;
				for (int j = 0; j < sharkList[i].s; j++) { //s칸이동
					nr += dr[sharkList[i].d];
					nc += dc[sharkList[i].d];
					
					//범위밖이다
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
						//범위 밖 전단계
						nr -= dr[sharkList[i].d];
						nc -= dc[sharkList[i].d];
						//방향바꾸고 
						int d = sharkList[i].d;
						if(d == 0) sharkList[i].d = 1;
						if(d == 1) sharkList[i].d = 0;
						if(d == 2) sharkList[i].d = 3;
						if(d == 3) sharkList[i].d = 2;
						
						//그방향으로 다시 한칸 가
						nr += dr[sharkList[i].d];
						nc += dc[sharkList[i].d];
					}
				}
				//기존 위치 0으로 바꿔
				map[sharkList[i].r][sharkList[i].c] = 0;
				//이동할 위치 넣음
				sharkList[i].r = nr;
				sharkList[i].c = nc;
			}
		}
		
		//상어 이동시켜
		for (int i = 1; i <= M ; i++) {
			//죽지 않은 상어에 대해서
			if(!sharkList[i].isdead) {
				int r = sharkList[i].r;
				int c = sharkList[i].c;
				//같은 자리에 이미 상어가 있다면
				if(map[r][c] != 0) {
					int num = map[r][c];
					int size = sharkList[num].z; //해당 번호의 상어의 크기
					int now = sharkList[i].z; //지금 상어의 크기
					if(now > size) {
						map[r][c] = i; //지금상어가 더 크다면 그 상어번호를 남기고
						sharkList[num].isdead = true; //해당상어죽어
					}else {
						sharkList[i].isdead = true;//현재 내가 죽음
					}
					continue;
				}
				map[r][c] = i; //해당 번호의 상어를 놔
			}	
		}
	}
}
