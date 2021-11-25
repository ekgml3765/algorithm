package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11404_플로이드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		int map[][] = new int[n][n];
		int INF = (100000*n)+1; //총합의 최대크기
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(i != j) //시작도시와 도착도시가 같은 경우가 없기떄문에
					map[i][j] = INF;
			}
		}
		for(int i = 0 ; i < m ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int num = Integer.parseInt(st.nextToken());
			map[r][c] = (map[r][c] > num)? num : map[r][c];
		}
		//플로이드 워셜
		for (int k = 0; k < map.length; k++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][k] + map[k][j] < map[i][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(((map[i][j] == INF)? 0 : map[i][j]) + " ");
			}
			System.out.println();
		}
	}
}
