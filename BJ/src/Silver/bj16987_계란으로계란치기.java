package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16987_계란으로계란치기 {

	static int N;

	static class Agg {
		int weight, durability;

		public Agg(int durability, int weight) {
			this.weight = weight;
			this.durability = durability;
		}
	}

	static Agg list[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		list = new Agg[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			list[i] = new Agg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		dfs(0, 0);
		System.out.println(ans);
	}

	static int ans = 0;

	private static void dfs(int idx, int cnt) {
		if (idx == N) {
			ans = Math.max(ans, cnt);
			return;
		}
		if (list[idx].durability <= 0 || cnt == N - 1) {
			dfs(idx + 1, cnt);
			return;
		}
		int copy = cnt;
		for (int i = 0; i < list.length; i++) {
			if (list[i].durability > 0 && idx != i) {
				list[idx].durability -= list[i].weight;
				list[i].durability -= list[idx].weight;
				if (list[idx].durability <= 0)
					cnt++;
				if (list[i].durability <= 0)
					cnt++;
				dfs(idx + 1, cnt);
				list[idx].durability += list[i].weight;
				list[i].durability += list[idx].weight;
				cnt = copy;
			}
		}
	}
}