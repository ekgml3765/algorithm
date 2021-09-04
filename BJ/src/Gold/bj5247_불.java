package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj5247_불 {
	static class Node{
		int r, c, cnt;
		boolean fire;
		public Node(int r, int c, int cnt, boolean fire) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.fire = fire;
		}
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		out: for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			char map[][] = new char[n][m];
			Queue<Node> queue = new LinkedList<Node>();
			List<Node> fire = new ArrayList<Node>();
			boolean visit[][][] = new boolean[n][m][2];
			int r = 0, c = 0;
			for (int i = 0; i < n ; i++) {
				String s = in.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '*')
						fire.add(new Node(i, j, 0, true));
					if(map[i][j] == '@') {
						r = i;
						c = j;
					}		
				}
			}//end for
			for (int i = 0; i < fire.size(); i++) {
				Node node = fire.get(i);
				queue.add(node);
				visit[node.r][node.c][1] = true;
			}
			queue.add(new Node(r, c, 0, false));
			visit[r][c][0] = true;
			String answer = "IMPOSSIBLE";
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];
					if(node.fire) {
						if(nr < 0 || nc < 0 || nr >= n || nc >= m || visit[nr][nc][1] || map[nr][nc] == '#')
							continue;
						visit[nr][nc][1] = true;
						queue.add(new Node(nr, nc, node.cnt+1, true));
					}else {
						if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
							System.out.println(node.cnt+1);
							continue out;
						}
						if(visit[nr][nc][0] || visit[nr][nc][1] || map[nr][nc] == '#')
							continue;
						visit[nr][nc][0] = true;
						queue.add(new Node(nr, nc, node.cnt+1, false));
					}
				}
			}
			System.out.println(answer);
		}
	}
}
