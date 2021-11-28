package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13549_숨바꼭질3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean visit[] = new boolean [100001];
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(N, 0));
		visit[N] = true;
		int ans = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == K) {
				ans = p.y;
				break;
			}
			int arr[] = {p.x*2, p.x-1, p.x+1};
			for(int i = 0 ; i < 3; i++) {
				int next = arr[i];
				if(next <= 100000 && next >= 0) {
					if(visit[next])
						continue;
					visit[next] = true;
					queue.add(new Point(next, (i==0)? p.y:p.y+1));
				}
			}
		}
		System.out.println(ans);
	}
}
