package Gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1726_로봇 {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static class Node{
		int r, c, d, cnt;
		public Node(int r, int c, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken()); //행
		int N = Integer.parseInt(st.nextToken()); //열
		int map[][] = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		int startR = Integer.parseInt(st.nextToken())-1;
		int startC = Integer.parseInt(st.nextToken())-1;
		int currD = Integer.parseInt(st.nextToken());
		currD = (currD == 4 || currD == 1)? currD%4 : ((currD == 3)? 2 : 3);
		st = new StringTokenizer(in.readLine());
		int endR = Integer.parseInt(st.nextToken())-1;
		int endC = Integer.parseInt(st.nextToken())-1;
		int endD = Integer.parseInt(st.nextToken());
		endD = (endD == 4 || endD == 1)? endD%4 : ((endD == 3)? 2 : 3);
		int ans = Integer.MAX_VALUE;
		boolean visit[][][] = new boolean [M][N][4];
		Queue<Node> queue = new LinkedList<Node>();
		visit[startR][startC][currD] = true;
		queue.add(new Node(startR, startC, currD, 0));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.r == endR && node.c == endC) {
				if(node.d != endD) {
					int dif = Math.abs(node.d - endD);
					node.cnt = (dif==1 || dif == 3)? node.cnt+1 : node.cnt+2;
				}
				ans = Math.min(ans, node.cnt);
				continue;
			}		
			for (int i = 0; i < 4; i++) {
				int nd = (node.d + i) % 4;
				int dif = Math.abs(node.d - nd);
				int cnt = node.cnt;
				if(dif == 0) {
					for (int j = 1; j <= 3; j++) {
						int nr = node.r + (dr[nd]*j);
						int nc = node.c + (dc[nd]*j);
						if( nr < 0 || nc < 0 || nr >= M || nc >= N || map[nr][nc] == 1)
							break;
						if(visit[nr][nc][nc])
							continue;
						visit[nr][nc][nd] = true;
						queue.add(new Node(nr, nc, nd, cnt+1));
					}
				}
				else {
					if(visit[node.r][node.c][nd])
						continue;
					cnt = (dif==1 || dif == 3)? cnt+1 : cnt+2;
					visit[node.r][node.c][nd] = true;
					queue.add(new Node(node.r, node.c, nd, cnt));
				}
			}
		}
		System.out.println(ans);
	}
}
