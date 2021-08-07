package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7569_토마토 {

	static class tomato{
		int h, r, c, cnt;
		public tomato(int h, int r, int c, int cnt) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}	
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int map[][][] = new int[H][N][M];
		int zero = 0;
		int ans = 0;
		List<tomato> list = new ArrayList<tomato>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i <N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if(map[h][i][j] == 0)
						zero++;
					if(map[h][i][j] == 1)
						list.add(new tomato(h, i, j, 0));
				}
			}	
		}//입력 끝
		
		if(zero == 0) {
			System.out.println(ans);
			return;
		}
		boolean visit[][][] = new boolean[H][N][M];
		Queue<tomato> queue = new LinkedList<tomato>();
		for (tomato tomato : list) {
			visit[tomato.h][tomato.r][tomato.c] = true;
			queue.add(tomato);
		}
		while(!queue.isEmpty()) {
			tomato t = queue.poll();
			if(zero == 0) {
				ans = t.cnt;
			}
			//앞뒤.
			int front = t.h -1;
			int back = t.h + 1;
			if(front >= 0 && front < H && !visit[front][t.r][t.c] && map[front][t.r][t.c] == 0) {
				visit[front][t.r][t.c] = true;
				queue.add(new tomato(front, t.r, t.c, t.cnt+1));
				zero--;
			}
			if(back >= 0 && back < H && !visit[back][t.r][t.c] && map[back][t.r][t.c] == 0) {
				visit[back][t.r][t.c] = true;
				queue.add(new tomato(back, t.r, t.c, t.cnt+1));
				zero--;
			}
			for (int d = 0; d < 4; d++) {//4방향
				int nr = t.r + dr[d];
				int nc = t.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[t.h][nr][nc] || map[t.h][nr][nc] != 0)
					continue;
				visit[t.h][nr][nc] = true;
				queue.add(new tomato(t.h,nr, nc, t.cnt+1));
				zero--;
			}		
		}
		System.out.println(ans = (zero > 0)? -1: ans);
	}
}
