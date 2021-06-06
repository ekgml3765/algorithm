package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14888_연산자끼워넣기 {

	static int N, arr[],cnt;
	static long sum,max, min;
	static char operation[], sel[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		operation = new char[N - 1];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());

		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(st.nextToken());
			char c = 'c';
			if (i == 0)
				c = '+';
			else if (i == 1)
				c = '-';
			else if (i == 2)
				c = '*';
			else if (i == 3)
				c = '/';

			for (int j = 0; j < n; j++) {
				operation[idx] = c;
				idx++;
			}
		}

		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		sel = new char[N - 1];
		visit = new boolean[N - 1];
		cnt = 0;
		perm(0);
		
		System.out.println(max);
		System.out.println(min);

	}

	private static void perm(int idx) {

		if (idx == N - 1) {
			sum = 0;	
			calc();
			max = (sum > max) ? sum : max;
			min = (sum < min) ? sum : min;
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (!visit[i]) {
				visit[i] = true;
				sel[idx] = operation[i];
				perm(idx + 1);
				visit[i] = false;
			}
		}
	}

	private static void calc() {
		
		sum = arr[0];
		for (int i = 1; i < N; i++) {
			char c = sel[i-1];
			if (c == '+') {
				sum += arr[i];		
			} else if (c == '-') {
				sum -= arr[i];
			} else if (c == '*') {
				sum *= arr[i];
			} else if (c == '/'){
				sum/=arr[i];
			}
			
		}
	}
}
