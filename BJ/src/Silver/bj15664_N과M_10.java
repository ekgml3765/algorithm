package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class bj15664_N과M_10{
	static int N, M, arr[];
	static int[] sel;
	static boolean check[];
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet <String> set = new LinkedHashSet<>();
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
		sel = new int[M];
		check = new boolean[N];
		comb(0, 0);
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
	}

	private static void comb(int idx, int s_idx) {
		if(idx == M) {
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < sel.length; i++) {
				sb2.append(sel[i] + " ");
			}
			sb2.append("\n");
			set.add(sb2.toString());
			return;
		}
		for (int i = s_idx; i < arr.length; i++) {
				sel[idx] = arr[i];
				comb(idx+1, i+1);
		}
	}
}
