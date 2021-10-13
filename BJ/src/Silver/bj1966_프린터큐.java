package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1966_프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Integer order[] = new Integer[N];
			st = new StringTokenizer(in.readLine());
			Queue<Point> queue = new LinkedList<Point>();
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				order[i] = num;
				queue.add(new Point(i, num));
			}
			int idx = 0;
			int cnt = 1;
			Arrays.sort(order, Collections.reverseOrder());
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				if(p.y == order[idx]) {
					if(p.x == M) {
						System.out.println(cnt);
						break;
					}
					cnt++;
					idx++;
				}else {
					queue.add(p);
				}
			}
		}
	}
}
