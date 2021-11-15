package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1022_소용돌이예쁘게출력하기 {
	static int r1, c1, r2, c2, len = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
	
		String ans[][] = new String[Math.abs(r1-r2)+1][Math.abs(c1-c2)+1];
		for (int i = r1, r = 0; i <= r2; i++, r++) {
			for (int j = c1, c = 0; j <= c2; j++, c++) {
				ans[r][c] = solve(i,j);
			}
		}
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				StringBuilder sb = new StringBuilder();
				int d = len - ans[i][j].length();
				while(d-- > 0) {
					sb.append(" ");
				}
				sb.append(ans[i][j]);
				if(j != ans[0].length-1)
					sb.append(" ");
				System.out.print(sb);
			}
			System.out.println();
		}
	}
	
	private static String solve(int r, int c) {
		//행 열 구분
		int num = 0;
		if(Math.abs(r) < Math.abs(c)) {
			//열이 더 큼
			num = (int)Math.pow(Math.abs(c)*2, 2)+1;
			if(c <= 0) { //음수
				num += Math.abs(c-r);
			}else {//양수
				num -= 2*c; 
				num -= Math.abs(c+r);
			}
		}else {
			num = (int)Math.pow(Math.abs(r)*2, 2)+1;
			if( r <= 0) {
				num -= Math.abs(r-c);
			}else {
				num += 2*r;
				num += Math.abs(r+c);
			}
		}
		String returnNum = Integer.toString(num);
		len = Math.max(len, returnNum.length());
		return returnNum;
	}

}
