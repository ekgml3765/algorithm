package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class swea_2112_보호필름 {
	static int ans, D, W, K, map[][], newMap[][], sel[], sel2[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			ans = D;
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 검사
			boolean flag = check(map);
			if (flag)
				ans = 0;
			else {
				// 약품투입할 곳 뽑기 1~D까지
				for (int r = 1; r <= D; r++) {
					sel2 = new int[r];
					perm(0); // A,B중 뭐 넣을지 고름
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static boolean perm(int idx) {
		if (idx == sel2.length) {
			sel = new int[sel2.length];
			if(comb(0, 0))
				return true;
			return false;
		}
		for (int i = 0; i < 2; i++) {
			sel2[idx] = i;
			if(perm(idx + 1))
				return true;
		}
		return false;
	}

	private static boolean comb(int idx, int s_idx) {
		if (s_idx == sel.length) {
			newMap = new int[D][W];
			for (int i = 0; i < map.length; i++) {
				newMap[i] = map[i].clone();
			}
			for (int i = 0; i < sel.length; i++) {
				go(sel[i], sel2[i]);
			}
			boolean flag = check(newMap);
			if (flag) {
				ans = Math.min(ans, sel.length);
				return true;
			}
			return false;
		}
		if (idx == D)
			return false;
		sel[s_idx] = idx;
		if (comb(idx + 1, s_idx + 1))
			return true;
		if (comb(idx + 1, s_idx))
			return true;
		return false;
	}

	private static void go(int i, int num) {
		for (int j = 0; j < W; j++) {
			newMap[i][j] = num;
		}
	}

	private static boolean check(int map[][]) {
		int cel = 0;
		for (int j = 0; j < W; j++) {
			int num = map[0][j];
			int cnt = 0;
			for (int i = 0; i < D; i++) {
				if (num == map[i][j])
					cnt++;
				else {
					num = map[i][j];
					cnt = 1;
				}
				if (cnt == K)
					break;
			}
			if (cnt < K)
				return false;
		}
		return true;
	}
}
