package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15657_N과M_8 {

	static int N, M, arr[];
	static int[] sel;
	static boolean check[];
	static StringBuilder sb = new StringBuilder();
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
		check = new boolean[N];
		sel = new int[M];
		perm(0);
		System.out.println(sb);
	}
	private static void perm(int idx) {
		if(idx == M) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(idx == 0 || (idx > 0 && sel[idx-1] <= arr[i])) {
				sel[idx] = arr[i];
				perm(idx+1);
			}
			}
		}
	}

