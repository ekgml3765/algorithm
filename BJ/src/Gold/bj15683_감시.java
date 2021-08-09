package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj15683_감시 {

	static int arr[][] = { { 0, 1, 2, 3 }, { 0, 1 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 }, { 0 } };
	static int sel[];
	static List<cctv> list;
	static int map[][],copy[][], N, M, zeroCnt=0, ans = Integer.MAX_VALUE;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static class cctv{
		int r, c, num;
		public cctv(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] != 6) {
					list.add(new cctv(i, j, map[i][j]-1));
				}
				if(map[i][j] == 0)
					zeroCnt++;
			}
		}
		sel = new int[list.size()];
		perm(0);
		System.out.println(ans);
	}
	private static void perm(int idx) {
		if (idx == list.size()) {
			copy = new int[N][];
			for (int i = 0; i < N; i++) {
				copy[i] = map[i].clone();
			}
			int del = go();
			ans = Math.min(ans, zeroCnt-del);
			return;
		}
		int num = list.get(idx).num;
		for (int i = 0; i < arr[num].length; i++) {
			sel[idx] = arr[num][i];
			perm(idx + 1);
		}
	}
	private static int go() {
		int del = 0;
		for (int i = 0; i < sel.length; i++) {
			cctv cctv = list.get(i);
			int dir = arr[cctv.num][sel[i]];
			int d = dir;
			if (cctv.num == 0) {
				del += view(dir, cctv);
			}
			if (cctv.num == 1) {
				for (int j = 0; j < 2; j++) {
					del += view(d, cctv);
					d+=2;
				}
			}
			if (cctv.num == 2) {
				for (int j = 0; j < 2; j++) {
					del += view(d, cctv);
					d = (d+1) % 4;
				}
			}
			if (cctv.num == 3) {
				for (int j = 0; j < 3; j++) {
					del += view(d, cctv);
					d = (d+1) % 4;
				}
			}
			if (cctv.num == 4) {
				for (int j = 0; j < 4; j++) {
					del += view(j, cctv);
				}
			}
		}
		return del;
	}
	private static int view(int d, cctv cctv) {
		int r = cctv.r, c = cctv.c;
		int cnt = 0;
		while(true) {
			r+=dr[d];
			c+=dc[d];
			if(r < 0 || c < 0 || r >= N || c >= M || copy[r][c] == 6 )
				break;
			if(copy[r][c] > 0)
				continue;
			copy[r][c] = 7;
			cnt++;
		}
		return cnt;
	}
}
