package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_2105_디저트카페 {
	static int ans, N;
	static int map[][];

	static class Node {
		int r, c, d, cnt;
		int dir[] = new int[4];
		public Node(int r, int c, int cnt, int d) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.d = d;
		}
	}
	static int dr[] = { -1, 1, 1, -1 };
	static int dc[] = { 1, 1, -1, -1 };
	static boolean visit[][];
	static boolean dessert[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			ans = -1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visit = new boolean[N][N];
					dessert = new boolean[101];
					Node node = new Node(i, j, 0, 0);
					dfs(i, j, node);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	public static void dfs(int r, int c, Node node) {
		if ((node.r == r && node.c == c) && node.cnt >= 4) {
			ans = Math.max(ans, node.cnt);
		}
		for (int d = 0; d < 4; d++) {
			int nr = node.r + dr[d];
			int nc = node.c + dc[d];
			// 범위밖
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc]) {
				continue;
			}
			// 역방향 금지
			if (node.cnt != 0 && d == (node.d+2)%4)
				continue;
			// 디저트 체크
			if (dessert[map[nr][nc]])
				continue;
			// 한번 다녀온 방향 불가
			if(node.d != d && (node.dir[d] > 0))
				continue;
			Node next = new Node(nr, nc, node.cnt + 1, d);
			for (int i = 0; i < 4; i++) {
				next.dir[i] = node.dir[i];
			}
			dessert[map[nr][nc]] = true;
			visit[nr][nc] = true;
			dfs(r, c, next);
			visit[nr][nc] = false;
			dessert[map[nr][nc]] = false;
		}
	}

}
