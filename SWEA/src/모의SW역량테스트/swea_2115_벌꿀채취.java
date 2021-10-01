package 모의SW역량테스트;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea_2115_벌꿀채취 {
	static int N, M, C, map[][], ans, num;
	static int sel[], max[];
	static boolean sel2[];
	static Point arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N  = Integer.parseInt(st.nextToken());
			M  = Integer.parseInt(st.nextToken());
			C  = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			arr = new Point[N*((N-M)+1)];
			max = new int[arr.length];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N-M; j++) {
					arr[idx] = new Point(i, j);
					int list[] = new int[M];
					for (int k = 0; k < list.length; k++) {
						list[k] = map[i][j+k];
					}
					sel2 = new boolean[M];
					num = 0;
					powerSet(0, list);
					max[idx] = num;
					idx++;
				}
			}
			sel = new int[2];
			comb(0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void powerSet(int idx, int[] arr) {
		if(idx == M) {
			int sum = 0;
			int honey = 0;
			for (int i = 0; i < arr.length; i++) {
				if(sel2[i]) {
					sum +=arr[i];
					honey += arr[i]*arr[i];
					if(sum > C)
						return;
				}
			}
			num = Math.max(num, honey);
			return;
		}
		sel2[idx] = true;
		powerSet(idx+1, arr);
		sel2[idx] = false;
		powerSet(idx+1, arr);
	}
	
	private static void comb(int idx, int s_idx) {
		if(s_idx == 2) {
			if((arr[sel[0]].x != arr[sel[1]].x) || ((arr[sel[0]].x == arr[sel[1]].x) && arr[sel[0]].y+M-1 < arr[sel[1]].y)) {
				ans = Math.max(ans, max[sel[0]]+max[sel[1]]);
			}
			return;
		}
		if(idx == arr.length)
			return;
		sel[s_idx] = idx;
		comb(idx+1, s_idx+1);
		comb(idx+1, s_idx);
	}
}
