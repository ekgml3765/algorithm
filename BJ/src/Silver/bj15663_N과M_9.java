package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj15663_N과M_9 {

	static int N, M, arr[];
	static int[] sel;
	static boolean check[];
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		check = new boolean[100001];
		sel = new int[M];
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int idx) {
		if (idx == M) {
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < sel.length; i++) {
				sb2.append(sel[i] + " ");
			}
			sb2.append("\n");
			if(!set.contains(sb2.toString())){
				set.add(sb2.toString());
				sb.append(sb2);
			}
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
