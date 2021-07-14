package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14888_연산자끼워넣기_v2 {
	static int N, number[], operation[];
	static int max, min;


	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		number = new int[N];
		operation = new int[4];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < 4; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		calc(number[0], 1);
		
		System.out.println(max);
		System.out.println(min);

	}

	private static void calc(int num, int idx) {

		if (idx == N) {	
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operation[i] > 0) {
				
				operation[i]--;
				
				switch (i) {
				case 0: calc(num+number[idx],idx+1); break;
				case 1: calc(num-number[idx],idx+1); break;
				case 2: calc(num*number[idx],idx+1); break;
				case 3: calc(num/number[idx],idx+1); break;
				}
				
				operation[i] ++;
			}
		}
	}

}
