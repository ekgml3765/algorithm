package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14888_연산자끼워넣기_2회독 {

	static int N, A[], min = Integer.MAX_VALUE, max=Integer.MIN_VALUE, op[], sel[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		A = new int[N];
		op = new int[4];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		sel = new int[N-1];
		perm(0, A[0]);
		System.out.println(max + "\n" + min);
	}
	private static void perm(int idx, int sum) {
		if(idx == N-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				if(i == 0) {
					perm(idx+1, sum+A[idx+1]);
				}else if(i == 1) {
					perm(idx+1, sum-A[idx+1]);
				}else if(i == 2) {
					perm(idx+1, sum*A[idx+1]);
				}else {
					perm(idx+1, sum/A[idx+1]);
				}
				op[i]++;
			}
		}
	}
}
