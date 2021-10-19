package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj14888_연산자끼워넣기 {
	static int N, A[], min, max;
	static char character[] = { '+', '-', '*', '/' };
	static char arr[], sel[];
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		arr = new char[N - 1];
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				arr[idx] = character[i];
				idx++;
			}
		}
		sel = new char[N - 1];
		check = new boolean[N - 1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		perm(0);
		System.out.println(max + "\n" + min);
	}

	private static void cul() {
			int n = A[0];
			for (int i = 1; i < N; i++) {
				char c = sel[i-1];
				int sum = 0;
				switch (c) {
				case '+': {
					n += A[i];
					break;
				}
				case '-': {
					n -= A[i];
					break;
				}
				case '*': {
					n *= A[i];
					break;
				}
				case '/': {
					n /= A[i];
					break;
				}
				}
			}
			min = Math.min(min, n);
			max = Math.max(max, n);

	}

	private static void perm(int idx) {
		if (idx == sel.length) {
			cul();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!check[i]) {
				check[i] = true;
				sel[idx] = arr[i];
				perm(idx + 1);
				check[i] = false;
			}
		}

	}
}
