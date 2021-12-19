package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj12851_숨바꼭질2 {
	static int N, K, time, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(time + "\n" + cnt);
	}

	private static void bfs() {
		int visit[] = new int [100001];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(N, 0));
		visit[N] = 1;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == K) {
				if(cnt == 0)
					time = p.y; //가장 빠른 시간
				if(time == p.y)
					cnt++; //갯수 증가
				continue;
			}
			int arr[] = {p.x-1, p.x+1, p.x*2};
			for (int i = 0; i < 3; i++) {
				int next = arr[i];
				if(next < 0 || next > 100000)
					continue;
				if(visit[next] == 0 || visit[next] == p.y+1) {
					visit[next] = p.y+1;
					queue.add(new Point(next, p.y+1));
				}
			}
		}
		}
}
