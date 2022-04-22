package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import Gold.bj16236_아기상어.Fish;

public class bj16236_아기상어_3회독 {

	static int N, map[][], s_r, s_c, size, fishcnt = 0, time = 0;
	static int dr[] = {-1, 1, 0, 0}; 
	static int dc[] = {0, 0, -1, 1};
	static class Node {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					s_r = i;
					s_c = j;
					size = 2;
				}
			}
		}	
		while(move());
		System.out.println(time);
	}
	private static boolean move() {
		boolean visit[][] = new boolean [N][N];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(s_r, s_c, 0));
		visit[s_r][s_c] = true;
		boolean flag = false;
		int fish_r = N;
		int fish_c = N;
		int fish_time = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			//먹을 수 있는 물고기
			if((map[node.r][node.c] != 9 && map[node.r][node.c] != 0) && size != map[node.r][node.c] && node.cnt <= fish_time ) {
				flag = true;
				if(node.cnt < fish_time) {
					fish_r = node.r;
					fish_c = node.c;
					fish_time = node.cnt;
				}else {
					//더 위에, 왼쪽
					if(node.r <= fish_r) {
						if(node.r == fish_r) {
							fish_c = (node.c < fish_c)? node.c : fish_c;
						}else {
							fish_r = node.r;
							fish_c = node.c;
						}
					}
				}
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] > size)
					continue;
				visit[nr][nc] = true;
				queue.add(new Node(nr, nc, node.cnt + 1));
			}
			
		}
		
		if(flag) {
			time += fish_time;
			map[fish_r][fish_c] = 9;
			map[s_r][s_c] = 0;
			s_r = fish_r;
			s_c = fish_c;
			fishcnt++;
			if(size == fishcnt) {
				size++;
				fishcnt = 0;
			}
			return true;
		}
			
		return false;
	}
}
