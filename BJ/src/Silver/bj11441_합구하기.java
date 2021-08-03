package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11441_합구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int sum[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i < N+1; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum[i] = num + sum[i-1];
		}
		int M = Integer.parseInt(in.readLine());
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(sum[b] - sum[a-1]);
		}
	}
}
