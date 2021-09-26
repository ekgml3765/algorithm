package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class bj2800_괄호제거 {
	static char arr[];

	static class Node {
		int idx;
		char c;

		public Node(int idx, char c) {
			this.idx = idx;
			this.c = c;
		}
	}

	static List<Point> list;
	static boolean sel[];
	static Set<String> ans;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arr = in.readLine().toCharArray();
		Stack<Node> stack = new Stack<>();
		list = new ArrayList<Point>();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (c == '(')
				stack.add(new Node(i, c));
			if(c == ')') {
				Node node = stack.pop();
				list.add(new Point(node.idx, i));
			}
		}
		ans = new TreeSet<String>();
		sel = new boolean[list.size()];
		powerSet(0);
		for (String s : ans) {
			System.out.println(s);
		}
	}
	private static void powerSet(int idx) {
		if(idx == sel.length) {
			StringBuilder sb = new StringBuilder();
			boolean check[] = new boolean[arr.length];
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					check[list.get(i).x] = true;
					check[list.get(i).y] = true;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				if(!check[i])
					sb.append(arr[i]);
			}
			if(sb.length() != arr.length)
				ans.add(sb.toString());
			return;
		}
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);	
	}
}
