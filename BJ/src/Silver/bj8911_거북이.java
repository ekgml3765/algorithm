package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj8911_거북이 {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			String s = in.readLine();
			int r = 0;
			int c = 0;
			int s_r = 0;
			int m_r = 0;
			int s_c = 0;
			int m_c = 0;
			int d = 0;
			for (int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
				case 'F':{
					r += dr[d];
					c += dc[d];
					break;
				}
				case 'B':{
					r -= dr[d];
					c -= dc[d];
					break;
				}
				case 'L':{
					d = (d-1 < 0 )? 3 : d-1;
					break;
				}
				case 'R':{
					d = (d+1)%4;
					break;
				}
				}
				s_r = Math.min(s_r, r);
				s_c = Math.min(s_c, c);
				m_r = Math.max(m_r, r);
				m_c = Math.max(m_c, c);
			}
			int row = Math.abs(s_r) + Math.abs(m_r);
			int col = Math.abs(s_c) + Math.abs(m_c);
			System.out.println(row*col);
		}
	}
}
