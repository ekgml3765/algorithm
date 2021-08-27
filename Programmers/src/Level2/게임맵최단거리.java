package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
	static class Node {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public int solution(int[][] maps) {
		int answer = -1;
		int R = maps.length;
		int C = maps[0].length;
		boolean visit[][] = new boolean[R][C];
		Queue<Node> queue = new LinkedList<>();
		visit[0][0] = true;
		queue.add(new Node(0, 0, 1));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.r == R - 1 && node.c == C - 1) {
				answer = node.cnt;
				return answer;
			}
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || visit[nr][nc] || maps[nr][nc] == 0)
					continue;
				visit[nr][nc] = true;
				queue.add(new Node(nr, nc, node.cnt + 1));
			}
		}
		return answer;
	}
}
