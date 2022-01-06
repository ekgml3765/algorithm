package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오인턴십_거리두기확인하기 {
	static char map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Node {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int i = 0; i < 5; i++) {
			// map 초기화
			String arr[] = places[i];
			map = new char[5][5];
			for (int j = 0; j < 5; j++) {
				map[j] = arr[j].toCharArray();
			}
			answer[i] = bfs();
		}
		return answer;
	}

	public static int bfs() {
		boolean visit[][] = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 'P' && !visit[i][j]) {
					visit[i][j] = true;
					Queue<Node> queue = new LinkedList<>();
					queue.add(new Node(i, j, 0));
					while (!queue.isEmpty()) {
						Node node = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nr = node.r + dr[d];
							int nc = node.c + dc[d];
							// 범위밖, 이미 방문, 파티션은 제외
							if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || visit[nr][nc] || map[nr][nc] == 'X')
								continue;
							// 맨해튼 거리가 1인 거리
							if (node.cnt == 0) {
								if (map[nr][nc] == 'P')
									return 0;
								if (map[nr][nc] == 'O') {
									visit[nr][nc] = true;
									queue.add(new Node(nr, nc, node.cnt + 1));
								}
							} else { // 맨해튼 거리가 2
								if (map[nr][nc] == 'P')
									return 0;
							}
						}
					}
				}
			}
		}
		return 1;
	}
}
