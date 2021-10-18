package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16236_아기상어_2회독 {
	static int N, map[][], R, C, eatCnt = 0, t = 0, sharkSize = 2;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static class Node implements Comparable<Node>{
		int r, c, cnt;
		int size = 0;
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node o) {
			if(this.cnt == o.cnt) {
				if(this.r == o.r)
					return this.c - o.c;
				return this.r - o.r;
			}
			return this.cnt - o.cnt;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", cnt=" + cnt + ", size=" + size + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j <N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					R = i;
					C = j;
				}
			}
		}
		while(true) {
			if(!bfs())
				break;
		}
		System.out.println(t);
	}
	
	private static boolean bfs() {
		List<Node> list = new ArrayList<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		boolean visit[][] = new boolean[N][N];
		queue.add(new Node(R, C, 0));
		visit[R][C] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(map[node.r][node.c] > 0 && map[node.r][node.c] < sharkSize) {
				node.size = map[node.r][node.c];
				list.add(node);
				continue;
			}
			//상어가 지나갈 수 있는 칸이면 쭉 지나가면서 먹을 수 있는 물고기를 리스트에 넣어.
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] > sharkSize)
					continue;
				//빈칸, 사이즈 같거나, 작은 물고기
				visit[nr][nc] = true;
				queue.add(new Node(nr, nc, node.cnt+1));
			}
		}
		if(list.size() == 0) //먹을 물고기가 없다면  return false;
			return false;
		Collections.sort(list);
		Node fish = list.get(0);
		t += fish.cnt;
		map[R][C] = 0;
		map[fish.r][fish.c] = 0;
		eatCnt++;
		R = fish.r;
		C = fish.c;
		if(eatCnt == sharkSize) {
			sharkSize++;
			eatCnt = 0;
		}
		return true;
	}
}
