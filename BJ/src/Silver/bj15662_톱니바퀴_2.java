package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15662_톱니바퀴_2 {

	static int T, topni[][];
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(in.readLine());
		topni = new int[T][8];
		for (int i = 0; i < T; i++) {
			String s = in.readLine();
			for (int j = 0; j < 8; j++) {
				topni[i][j] = s.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			check = new boolean[T-1];
			check();
			rotation(num, d);
		}	
		int ans = 0;
		for (int i = 0; i < T; i++) {
			ans += topni[i][0];
		}
		System.out.println(ans);
	}
	private static void rotation(int num, int d) {
		turn(num, d);
		if(T > 1) {
			boolean turn[] = new boolean[T];
			turn[num] = true;
			//왼쪽
			int leftdir = d*-1;
			for (int i = num-1; i >= 0; i--) {
				if(check[i] && turn[i+1]) {
					turn[i] = true;
					turn(i, leftdir);
					leftdir *= -1;
				}
			}
			//오른쪽
			int rightdir = d*-1;
			for (int i = num+1; i < T; i++) {
				if(check[i-1] && turn[i-1]) {
					turn[i] = true;
					turn(i, rightdir);
					rightdir *= -1;
				}
			}
		}
	}

	private static void turn(int num, int d) {
		if(d == 1) {
			int tmp = topni[num][7];
			for (int i = 7; i > 0; i--) {
				topni[num][i] = topni[num][i-1];
			}
			topni[num][0] = tmp;
		}else {
			int tmp = topni[num][0];
			for (int i = 0; i < 7; i++) {
				topni[num][i] = topni[num][i+1];
			}
			topni[num][7] = tmp;
		}	
	}
	private static void check() {
		for (int i = 0; i < T-1; i++) {
			if(topni[i][2] != topni[i+1][6])
				check[i] = true;
		}
	}
}
