package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15652_N과M_4 {

	static int N, M;
	static int[] sel;
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new boolean[N+1];
		sel = new int[M];
		perm(0);
	}
	private static void perm(int idx) {
		if(idx == M) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+ " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(idx == 0 || (idx>0 && sel[idx-1] <= i)) {
				sel[idx] = i;
				perm(idx+1);
			}
		}
	}
}
