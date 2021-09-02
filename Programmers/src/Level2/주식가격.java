package Level2;

import java.util.Stack;

public class 주식가격 {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		solution(prices);
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty()) {
				if (prices[stack.peek()] > prices[i]) {
					Integer idx = stack.pop();
					answer[idx] = i - idx;
					continue;
				}
				break;
			}
			stack.add(i);
		}
		while (!stack.isEmpty()) {
			Integer idx = stack.pop();
			answer[idx] = prices.length - 1 - idx;
		}
		return answer;
	}
}
