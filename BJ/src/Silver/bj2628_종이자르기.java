package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2628_종이자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(in.readLine());
		int row[] = new int[R+1];
		int col[] = new int[C+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int d = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(d == 0)
				row[n]++;
			else
				col[n]++;
		}
		int idx = 0;
		int l = 0;
		for (int i = 0; i < col.length; i++) {
			if(col[i] == 1 || i == C) {
				l = Math.max(l, i-idx);
				idx = i;
			}
		}
		idx = 0;
		int w = 0;
		for (int i = 0; i < row.length; i++) {
			if(row[i] == 1 || i == R) {
				w = Math.max(w, i-idx);
				idx = i;
			}
		}
		System.out.println(w*l);
	}
}
