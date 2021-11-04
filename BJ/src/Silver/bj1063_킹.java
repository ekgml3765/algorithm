package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1063_킹 {
	static int dr[] = {1, 1, 0, -1, -1, -1, 0, 1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		String s = st.nextToken();
		int kingC = s.charAt(0)-65;
		int kingR = s.charAt(1)-'0';
		s = st.nextToken();
		int stoneC = s.charAt(0)-65;
		int stoneR = s.charAt(1)-'0';
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			String ss = in.readLine();
			int d = 0;
			switch (ss) {
			case "T":{
				d = 0;
				break;
			}
			case "RT":{
				d = 1;
				break;
			}
			case "R":{
				d = 2;
				break;
			}
			case "RB":{
				d = 3;
				break;
			}
			case "B":{
				d = 4;
				break;
			}
			case "LB":{
				d = 5;
				break;
			}
			case "L":{
				d = 6;
				break;
			}
			case "LT":{
				d = 7;
				break;
			}
			}
			int nr = kingR + dr[d];
			int nc = kingC + dc[d];
			int nnr = stoneR;
			int nnc = stoneC;
			if(nr < 1 || nc < 0 || nr > 8 || nc >= 8)
				continue;
			if(nr == stoneR && nc == stoneC) {
				nnr += dr[d];
				nnc += dc[d];
				if(nnr < 1 || nnc < 0 || nnr > 8 || nnc >= 8) {
					continue;
				}else {
					stoneR = nnr;
					stoneC = nnc;
				}
			}
			kingR = nr;
			kingC = nc;
		}
		System.out.printf("%c%d", (char)(kingC+65), kingR);
		System.out.println();
		System.out.printf("%c%d", (char)(stoneC+65), stoneR);
	}
}
