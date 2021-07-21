package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14500_테트로미노 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); //행
		int M = Integer.parseInt(st.nextToken()); //열
		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
		int tetromino[][][] = {//테트로미노
				{{0,1},{0,2},{0,3}}, // -
				{{1,0},{2,0},{3,0}}, // ㅣ
				{{0,1},{1,1},{1,0}}, // ㅁ
				{{1,-1},{1,0},{1,1}}, // ㅗ
				{{-1,1},{-1,0},{-1,-1}}, // ㅜ
				{{-1,0},{1,0},{0,1}}, // ㅏ
				{{1,0},{-1,0},{0,-1}}, // ㅓ
				{{0,1},{1,1},{1,2}}, // z
				{{0,-1},{1,-1},{1,-2}}, // z 반대
				{{1,0},{1,1},{2,1}}, // z 상하
				{{1,0},{1,-1},{2,-1}}, // z 상하대칭
				{{1,0},{2,0},{2,1}}, // ㄴ
				{{1,0},{2,0},{2,-1}}, // ㄴ 반대
				{{0,1},{1,1},{2,1}}, // ㄱ
				{{0,-1},{1,-1},{2,-1}}, // ㄱ 대칭
				{{1,0},{0,1},{0,2}}, //긴 ㄱ
				{{0,1},{0,2},{1,2}}, //긴 ㄱ 대칭
				{{1,0},{1,1},{1,2}},//긴 ㄴ 
				{{0,1},{0,2},{-1,2}} // 긴 ㄴ 대칭
		};
		int ans = 0;
		//모든 r,c에 대해서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int max = 0;
				for (int r = 0; r < tetromino.length; r++) { //모든 도형 다 대보기
					int cnt = 1;
					int sum = map[i][j];
					for (int d = 0; d < 3; d++) {
						int nr = i + tetromino[r][d][0];
						int nc = j + tetromino[r][d][1];
						//범위밖
						if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
						sum += map[nr][nc];
						cnt++;
					}
					if(cnt == 4) {
						max = Math.max(max, sum);
					}
				}
				ans = Math.max(ans, max);
			}
		}//end for
		System.out.println(ans);
		
	}
}
