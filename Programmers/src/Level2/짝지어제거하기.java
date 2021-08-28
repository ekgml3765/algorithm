package Level2;

import java.util.Stack;

public class 짝지어제거하기 {
	public int solution(String s) {
		if (s.length() == 1)
			return 0;
		Stack<Character> stack = new Stack<>();
		char arr[] = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty()) {
				stack.add(arr[i]);
			} else {
				if (stack.peek() == arr[i])
					stack.pop();
				else
					stack.add(arr[i]);
			}
		}
		if (!stack.isEmpty())
			return 0;
		return 1;
	}
}
