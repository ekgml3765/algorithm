package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_5644_무선충전 {
	static int map[][], M, A, a[], b[], ans;

	static class BC {
		int r, c, C, P;

		public BC(int r, int c, int C, int P) {
			this.r = r;
			this.c = c;
			this.C = C;
			this.P = P;
		}

		@Override
		public String toString() {
			return "BC [r=" + r + ", c=" + c + ", C=" + C + ", P=" + P + "]";
		}
	}

	static BC bcList[];
	static int dr[] = { 0, -1, 0, 1, 0 };
	static int dc[] = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			map = new int[10][10];
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			bcList = new BC[A];
			a = new int[M];
			b = new int[M];
			ans = 0;
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(in.readLine());
				int c = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				bcList[i] = new BC(r, c, C, P);
			} // 입력끝
			dfs(0, 0, 0, 9, 9, 0);
			System.out.println("#" + tc + " " +ans);
		}
	}

	private static void dfs(int t, int Ar, int Ac, int Br, int Bc, int sum) {
		List<Integer> Alist = new ArrayList<>();
		List<Integer> Blist = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < A; i++) {
			if (bcList[i].C >= Math.abs(Ar - bcList[i].r) + Math.abs(Ac - bcList[i].c))
				Alist.add(i);
			if (bcList[i].C >= Math.abs(Br - bcList[i].r) + Math.abs(Bc - bcList[i].c))
				Blist.add(i);
		}
		if (Alist.size() == 0 || Blist.size() == 0) {
			for (int i = 0; i < Alist.size(); i++) {
				max = Math.max(max, bcList[Alist.get(i)].P);
			}
			for (int i = 0; i < Blist.size(); i++) {
				max = Math.max(max, bcList[Blist.get(i)].P);
			}
		} else {
			for (int i = 0; i < Alist.size(); i++) {
				int num1 = Alist.get(i);
				for (int j = 0; j < Blist.size(); j++) {
					int num2 = Blist.get(j);
					if (num1 == num2) {
						max = Math.max(max, bcList[num1].P);
					} else {
						max = Math.max(max, bcList[num1].P + bcList[num2].P);
					}
				}
			}
		}
		if (t == M) {
			ans = sum+max;
			return;
		}
		dfs(t + 1, Ar + dr[a[t]], Ac + dc[a[t]], Br + dr[b[t]], Bc + dc[b[t]], sum + max);
	}
}
