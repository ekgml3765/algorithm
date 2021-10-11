package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		StringBuilder sb = new StringBuilder();
		int k = 1;
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if (!stack.isEmpty() && stack.peek() == num) {
				stack.pop();
				sb.append("-" + "\n");
			} else {
				if(!stack.isEmpty() && stack.peek() > num) {
					flag = true;
					break;
				}
				while (k <= num) {
					stack.add(k);
					sb.append("+" + "\n");
					k++;
				}
				stack.pop();
				sb.append("-" + "\n");
			}
		}
		if (!stack.isEmpty() || flag)
			System.out.println("NO");
		else
			System.out.println(sb);
	}
}
