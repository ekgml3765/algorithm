package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4179_불 {
	static int R, C, ans = 0;
	static char[][] map;
	static class Node{
		int r, c, cnt;
		boolean isFire;
		public Node(int r, int c, int cnt, boolean isFire) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.isFire = isFire;
		}
		@Override
		public String toString() {
			return r + " " + c + " " + cnt + " " + isFire;
		}
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map= new char[R][C];
		boolean visit[][] = new boolean[R][C];
		Queue<Node> queue = new LinkedList<>();
		Node jihun = null;
		for(int i = 0 ; i < R; i ++) {
			String s = in.readLine();
			for(int j = 0 ; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'J') {
					visit[i][j] = true;
					jihun = new Node(i, j, 0, false);
					map[i][j] = '.';
				}
				if(map[i][j] == 'F') {
					visit[i][j] = true;
					queue.add(new Node(i, j, 0, true));
					map[i][j] = '.';
				}
			}
		}
		queue.add(jihun);
		out: while(!queue.isEmpty()) {
			Node node = queue.poll();	
			for(int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
					if(!node.isFire) {
						ans = node.cnt+1;
						break out;
					}
					continue;
				}
				if(map[nr][nc]	== '#' || visit[nr][nc])
					continue;
				visit[nr][nc] = true;
				queue.add(new Node(nr, nc, node.cnt+1, node.isFire));
			}
		}
		System.out.println((ans==0)? "IMPOSSIBLE" : ans);
	}
}
