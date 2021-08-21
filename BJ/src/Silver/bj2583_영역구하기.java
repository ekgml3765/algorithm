package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2583_영역구하기 {

	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int map [][] = new int[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int startC = Integer.parseInt(st.nextToken());
			int startR = M-1-Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken())-1;
			int endR = M-1-(Integer.parseInt(st.nextToken())-1);
			for (int r = startR; r >= endR; r--) {
				for (int c = startC; c <= endC; c++) {
					map[r][c] = 1;
				}
			}
		}//입력 끝
		boolean visit[][] = new boolean[M][N];
		Queue<Point> queue = new LinkedList<Point>();
		int depart = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j] == 0) {
					depart ++;
					visit[i][j] = true;
					queue.add(new Point(i, j));
					int cnt = 0;
					while(!queue.isEmpty()) {
						Point node = queue.poll();
						cnt++;
						for (int d = 0; d < 4; d++) {
							int nr = node.x + dr[d];
							int nc = node.y + dc[d];
							if( nr < 0 || nc < 0 || nr >= M || nc >= N || map[nr][nc] == 1 || visit[nr][nc])
								continue;
							visit[nr][nc] = true;
							queue.add(new Point(nr, nc));
						}
					}
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(depart);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if(i!=list.size()-1)
				System.out.print(" ");
		}
	}
}
