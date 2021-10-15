package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj15665_N과M_11 {

	static int N, M;
	static Integer arr[];
	static int[] sel;
	static boolean check[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N ; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		arr = set.toArray(new Integer[set.size()]);
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
				sel[idx] = arr[i];
				perm(idx+1);
			}
		}
	}

