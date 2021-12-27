package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11060_점프점프 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = -1;
		boolean visit[] = new boolean[N];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		visit[0] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == N-1) {
				ans = p.y;
				break;
			}
			for(int i = 1; i <= arr[p.x]; i++) {
				int nextIdx = p.x+i;
				if(nextIdx >= N || visit[nextIdx])
					continue;
				visit[nextIdx] = true;
				queue.add(new Point(nextIdx, p.y+1));
			}
		}
		System.out.println(ans);
	}
}
