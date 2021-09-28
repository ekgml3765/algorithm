package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16953_AB {
	static class Point{
		long x, y;
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long ans = -1;
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(A, 0));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == B) {
				ans = p.y;
				break;
			}
			if(p.x > B)
				continue;
			for (int i = 0; i < 2; i++) {
				long num = p.x;
				if(i==0) {
					num *= 2;
				}
				if(i==1) {
					String s = Long.toString(num) + "1";
					num = Long.parseLong(s);
				}
				queue.add(new Point(num, p.y+1));
			}
		}
		System.out.println((ans==-1)? ans : ans+1);
		
	}
}
