package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2458_키순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
		}
		
		//플로이드 워셜
		for (int k = 0; k < map.length; k++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][k]== 1 && map[k][j] == 1) //거쳐서 갈 수 있는 것 다 체크
						map[i][j] = 1;
				}
			}
		}
		int ans = 0;
		out: for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(i != j) {
					// 둘다 0이다?
					if(map[i][j] != 1 && map[j][i] != 1) //둘중에 하나라도 갈 수 있으면 ㄱㅊ 근데 둘다 못간다? 그럼 순위 비교못함
						continue out;
				}			
			}
			ans++;
		}
		System.out.println(ans);
	}
}
