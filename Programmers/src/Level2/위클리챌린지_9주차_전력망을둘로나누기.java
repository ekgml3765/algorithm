package Level2;

import java.util.ArrayList;
import java.util.List;

public class 위클리챌린지_9주차_전력망을둘로나누기 {
	static List<Integer> list[];
	static boolean visit[];
	static int cnt;
	public static int solution(int n, int[][] wires) {
		int answer = n;
		list = new ArrayList[n + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < wires.length; i++) {
			int from = wires[i][0];
			int to = wires[i][1];
			list[from].add(to);
			list[to].add(from);
		}
		for (int i = 0; i < wires.length; i++) {
			int num1 = wires[i][0];
			int num2 = wires[i][1];
			visit = new boolean[n + 1];
			List<Integer> number = new ArrayList<Integer>();
			for (int j = 1; j <= n; j++) {
				if (!visit[j]) {
					cnt = 1;
					visit[j] = true;
					dfs(j, num1, num2);
					number.add(cnt);
				}
			}
			answer = Math.min(answer, Math.abs(number.get(0)-number.get(1)));
		}
		return answer;
	}

	private static void dfs(int from, int num1, int num2) {
		for (int i = 0; i < list[from].size(); i++) {
			int to = list[from].get(i);
			if (!visit[to]) {
				if((from == num1 && to == num2) || (from == num2 && to == num1))
					continue;
				cnt++;
				visit[to] = true;
				dfs(to, num1, num2);
			}
		}
	}
}
