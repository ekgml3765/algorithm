package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17298_오큰수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Point arr[] = new Point[N];
		int ans[] = new int[N];
		Stack<Point> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = new Point(i, Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && stack.peek().y < arr[i].y) {
				int idx = stack.pop().x;
				ans[idx] = arr[i].y;
			}
			stack.add(arr[i]);
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print((ans[i] == 0) ? -1 : ans[i]);
			System.out.print(" ");
		}
	}
}
