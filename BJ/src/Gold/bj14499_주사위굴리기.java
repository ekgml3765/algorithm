package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class bj14499_주사위굴리기 {

	static int dr[] = {0, 0, -1, 1 }; //동0 서1  북2 남3
	static int dc[] = {1, -1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dice[][] = new int[4][4];
		int[] dir = new int[K];
		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			dir[i] = Integer.parseInt(st.nextToken())-1;
		}// 입력 끝

		for (int i = 0; i < K; i++) {
			int d = dir[i];
			int nr = x + dr[d];
			int nc = y + dc[d];
			//범위밖 아웃
			if(nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			//주사위 해당 방향으로 돌려.
			if(d == 0) { //오른쪽
				int num = dice[1][3];
				for (int j = 3; j > 0; j--) {
					dice[1][j] = dice[1][j-1];
				}
				dice[1][0] = num;
				dice[3][1] = dice[1][3]; //바닥면
			}
			if(d == 1) { //왼쪽
				int num = dice[1][0];
				for (int j = 0; j < 3; j++) {
					dice[1][j] = dice[1][j+1];
				}
				dice[1][3] = num;
				dice[3][1] = dice[1][3];
			}
			if(d == 2) { //위
				int num = dice[0][1];
				for (int j = 0; j < 3; j++) {
					dice[j][1] = dice[j+1][1];
				}
				dice[3][1] = num;
				dice[1][3] = dice[3][1];
			}
			if(d == 3) { //아래
				int num = dice[3][1];
				for (int j = 3; j > 0; j--) {
					dice[j][1] = dice[j-1][1];
				}
				dice[0][1] = num;
				dice[1][3] = dice[3][1];
			}
			x = nr; //이동 좌표
			y = nc; //이동 좌표
			//칸이 0이면 주사위 바닥면 수를 칸에 복사
			if(map[x][y] == 0) {
				map[x][y] = dice[1][3];
			}else { //칸이 0이 아니면 칸에 쓰인 수가 주사위 바닥면을 복사.
				dice[1][3] = map[x][y];
				dice[3][1] = map[x][y];
				map[x][y] = 0;
			}
			//윗면에 쓰인 수 출력
			System.out.println(dice[1][1]);		
		}
		
	}
}
