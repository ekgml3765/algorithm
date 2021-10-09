package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2251_물통 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int list[] = new int[3];
		for(int i = 0; i < 3; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		int from[] = {0, 0, 1, 1, 2, 2};
		int to[] = {1, 2, 0, 2, 0, 1};
		boolean visit[][] = new boolean[201][201];
		boolean ans[] = new boolean[201];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0));
		ans[list[2]] = true;
		visit[0][0] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			int z = list[2]-x-y;
			
			for (int d = 0; d < 6; d++) {
				int next[] = {x, y, z};
				next[to[d]] += next[from[d]];
				next[from[d]] = 0;
				if(next[to[d]] > list[to[d]]) {
					next[from[d]] = next[to[d]] - list[to[d]];
					next[to[d]] = list[to[d]];
				}
				if(!visit[next[0]][next[1]]) {
					visit[next[0]][next[1]] = true;
					queue.add(new Point(next[0], next[1]));
					if(next[0] == 0)
						ans[next[2]] = true;
				}
			}
		}
		for(int i = 0; i <= list[2]; i++) {
			if(ans[i])
				System.out.print(i+ " ");
		}
		
	}
}
