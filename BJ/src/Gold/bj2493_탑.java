package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int top[] = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < top.length; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		int ans[] = new int[N];
		Stack<Point> stack = new Stack<Point>();
		for(int i = 0; i < N; i++) {
			if(stack.isEmpty()) {
				stack.add(new Point(i, top[i]));
			}else {
				while(!stack.isEmpty()) {
					if(stack.peek().y >= top[i]) {
						ans[i] = stack.peek().x+1;
						break;
					}else {
						stack.pop();
					}
				}
				stack.add(new Point(i, top[i]));
			}
			System.out.print(ans[i] + " ");
		}
	}
}
