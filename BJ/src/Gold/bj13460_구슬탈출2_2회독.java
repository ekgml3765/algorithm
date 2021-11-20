package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import Gold.bj13459_구슬탈출_2회독.Node;

public class bj13460_구슬탈출2_2회독 {
	static int N, M, ans = 0;
	static char map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Node {
		Point R, B;
		int cnt = 0;
		public Node(Point R, Point B, int cnt) {
			this.R = R;
			this.B = B;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		Point R = null, B = null;
		for(int i = 0; i < N; i++) {
			String s = in.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'R') {
					R = new Point(i, j);
					map[i][j] = '.';
				}
				if(map[i][j] == 'B') {
					B = new Point(i, j);
					map[i][j] = '.';
				}
			}
		}
		Queue<Node> queue = new LinkedList<>();
		boolean visit[][][][] = new boolean[N][M][N][M];
		visit[R.x][R.y][B.x][B.y] = true;
		queue.add(new Node(R, B, 0));
		out: while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.cnt >= 10)
				break;
			for(int d = 0; d < 4; d++) {
				Point nR = move(node.R, node.B, d);
				Point nB = move(node.B, nR, d);
				nR = move(nR, nB, d); //막혀있는 경우 - 한번 더 이동
				if(map[nB.x][nB.y] == 'O') //다른 방향으로 더 해봐야 하므로 컨티뉴
					continue;
				if(map[nR.x][nR.y] == 'O') {
					ans = node.cnt+1;
					break out;
				}
				if(visit[nR.x][nR.y][nB.x][nB.y])
					continue;
				visit[nR.x][nR.y][nB.x][nB.y] = true;
				queue.add(new Node(nR, nB, node.cnt+1));
			}
		}
		System.out.println((ans==0)? -1 : ans);
	}

	public static Point move(Point move, Point a, int d) {
		Point p = null;
		int r = move.x;
		int c = move.y;
		while (true) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(map[r][c]  == 'O') //이미 내가 구멍에 빠지면 ㄴㄴ
				break;
			if (map[nr][nc] == '#') //벽이면 ㄴㄴ 
				break;
			if((nr == a.x && nc == a.y) && map[nr][nc] != 'O')
				break;
			r = nr;
			c = nc;
		}
		p = new Point(r, c);
		return p;
	}
}
