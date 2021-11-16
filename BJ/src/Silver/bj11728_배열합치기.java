package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11728_배열합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		int B[] = new int[M];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		int a = 0;
		int b = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N+M ; i++) {
			if(a == N || b == M) {
				if(a == N)
					sb.append(B[b++] + " ");
				else
					sb.append(A[a++] + " ");
				continue;
			}else {
				if(A[a] <= B[b]) {
					sb.append(A[a++] + " ");
				}else {
					sb.append(B[b++] + " ");
				}
			}
		}
		System.out.println(sb);
		
	}
}
