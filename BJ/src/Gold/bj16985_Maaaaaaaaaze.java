package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16985_Maaaaaaaaaze {

	static int map[][][], copy[][][], ans = Integer.MAX_VALUE;
	static int dir[], order[];
	static boolean check[], visit[][][];
	static int dr[] = {-1, 1, 0, 0, 0, 0};
	static int dc[] = {0, 0, -1, 1, 0, 0};
	static int dz[] = {0, 0, 0, 0, -1, 1};
	static class Node{
		int r, c, z, cnt;
		public Node(int r, int c, int z, int cnt) {
			this.r = r;
			this.c = c;
			this.z = z;
			this.cnt = cnt;
		}	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5][5];
		dir = new int[5];
		order = new int[5];
		check = new boolean[5];
		for (int z = 0; z <5; z++) {
			for (int r = 0; r < 5; r++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int c = 0; c < 5; c++) {
					map[z][r][c] = Integer.parseInt(st.nextToken());
				}
			}
		}
		perm(0);
		System.out.println((ans ==Integer.MAX_VALUE)? -1 : ans);
	}
	// 판 쌓는 순서 정하기 - 순열
	private static void perm(int idx) {
		if(idx == 5) {
			copy = new int[5][5][5];
			for (int i = 0; i < order.length; i++) {
				rotation(0);
			}
			return;
		}		
		for (int i = 0; i < 5; i++) {
			if(!check[i]) {
				check[i] = true;
				order[idx] = i;
				perm(idx+1);
				check[i] = false;
			}
		}
	}
	// 4방향 중 회전 - 중복순열
	private static void rotation(int idx) {
		if(idx == 5) {
			for (int i = 0; i < order.length; i++) {
				int pan = order[i];
				int d = dir[pan];
				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						if(d==0) {
							copy[i][r][c] = map[pan][r][c];
						}
						if(d==1) {
							copy[i][c][4-r] = map[pan][r][c];
						}
						if(d==2) {
							copy[i][4-r][4-c] = map[pan][r][c];
						}
						if(d==3) {
							copy[i][4-c][r] = map[pan][r][c];
						}
					}
				}
			}
			if(copy[0][0][0] == 1 && copy[4][4][4] == 1)
				bfs();
			return;
		}
		for (int d = 0; d < 4; d++) {
			dir[idx] = d;
			rotation(idx+1);
		}	
	}
	// 최단길이
	private static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		visit = new boolean[5][5][5];
		queue.add(new Node(0, 0, 0, 0));
		visit[0][0][0] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.r == 4 && node.c == 4 && node.z == 4) {
				ans = Math.min(ans, node.cnt);
				if(ans==12){
                    System.out.println(12);
                    System.exit(0);
                }
				break;
			}
			for (int d = 0; d < 6; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				int nz = node.z + dz[d];
				if(nr < 0 || nc < 0 || nz < 0 || nr >= 5 || nc >= 5 || nz >= 5 || visit[nz][nr][nc] || copy[nz][nr][nc] == 0)
					continue;
				visit[nz][nr][nc] = true;
				queue.add(new Node(nr, nc, nz, node.cnt+1));
			}
		}
	}

}
