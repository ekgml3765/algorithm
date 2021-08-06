package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16926_배열돌리기 {

	static int N, M, map[][], R;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		for (int i = 0; i < R; i++) {
			rotation();
		}
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();

	}

	private static void rotation() {
		int startR = 0, endR = N - 1, startC = 0, endC = M - 1;
		
		
		while(true) {
			//왼
			int tmp = map[startR][startC];
			for(int j = startC; j < endC; j++) {
				map[startR][j] = map[startR][j+1];
			}

			//위
			for(int i = startR ; i < endR; i++) {
				map[i][endC] = map[i+1][endC];
			}
			
			//오른쪽
			for(int j = endC; j > startC ; j--) {
				map[endR][j] = map[endR][j-1]; 
			}
			//아래
			for (int i = endR; i > startR; i--) {
				map[i][startC] = map[i-1][startC];
			}
			map[startR+1][startC] = tmp;
			
			startR++;
			startC++;
			endR--;
			endC--;
			if(startR >= endR || startC >= endC)
				break;
		}
	}
}
