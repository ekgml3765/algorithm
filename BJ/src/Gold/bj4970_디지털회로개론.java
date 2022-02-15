package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class bj4970_디지털회로개론 {
	static char arr[];
	static int ans = 0, sel[];
	static HashMap<Character, Integer> map;
	static int not[] = { 2, 1, 0 };
	static int and[][] = { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 1, 2 }, };
	static int or[][] = { { 0, 1, 2 }, { 1, 1, 2 }, { 2, 2, 2 }, };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = in.readLine();
			if (s.equals("."))
				break;
			arr = s.toCharArray();
			map = new HashMap<>();
			ans = 0;
			map.put('0', 0);
			map.put('1', 1);
			map.put('2', 2);
			sel = new int[3];
			perm(0);
			System.out.println(ans);
		}
	}

	static int cnt = 0;

	private static void perm(int idx) {
		if (idx == 3) {
			map.put('P', sel[0]);
			map.put('Q', sel[1]);
			map.put('R', sel[2]);
			check();
			return;
		}
		for (int i = 0; i < 3; i++) {
			sel[idx] = i;
			perm(idx + 1);
		}
	}

	static Stack<Character> stack1;
	static Stack<Integer> stack2;
	private static void check() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (c == '(') {
				stack1.add(c);
				continue;
			} else if (c == ')') {
				while (!stack1.isEmpty()) {
					char top = stack1.peek();
					if (top == '(') {
						stack1.pop();
						break;
					}
					calc(stack1.pop());
				}
			} else {
				// 연산자
				if (c == '-' || c == '*' || c == '+') {
					// 우선순위
					if (stack1.isEmpty()) {
						stack1.add(c);
					} else {
						char top = stack1.peek();
						if ((int) top <= (int) c) {
							stack1.add(c);
							continue;
						} else {
							while (!stack1.isEmpty()) {
								top = stack1.peek();
								if ((int) top < (int) c) {
									break;
								}
								calc(stack1.pop());
							}
							stack1.add(c);
						}
					}
				} else {// 피연산자
					stack2.add(map.get(c));
				}
			}
		}
		// 스택 비워
		while (!stack1.isEmpty()) {
			char c = stack1.pop();
			calc(c);
		}
		int number = stack2.pop();
		if (number == 2)
			ans++;
	}

	private static void calc(char c) {
		if (c == '-') {
			int num = stack2.pop();
			num = not[num];
			stack2.add(num);
		} else if (c == '*') {
			int num1 = stack2.pop();
			int num2 = stack2.pop();
			stack2.add(and[num1][num2]);
		} else if (c == '+') {
			int num1 = stack2.pop();
			int num2 = stack2.pop();
			stack2.add(or[num1][num2]);
		}
	}
}
