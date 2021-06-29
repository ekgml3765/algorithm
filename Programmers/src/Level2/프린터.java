package Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 프린터 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int priorities[] = { 2, 1, 3, 2 };
		int location = 2;
		solution(priorities, location);
	}

	static class Node {
		int priority;
		int locationNum;

		public Node(int priority, int locationNum) {
			this.priority = priority;
			this.locationNum = locationNum;
		}
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;

		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < priorities.length; i++) {
			Node node = new Node(priorities[i], i);
			list.add(node);
		}
		
		int order = 1;
		out : while(list.size() != 0) {
			// List. 0번째 값이랑 다 비교.
			Node first = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				if(first.priority < list.get(i).priority) {//우선순위가 더 높다면
					list.remove(0);
					list.add(first);
					continue out;
				}
			}
			//우선순위가 가장 높다면 check를 봐
			if(first.locationNum == location) {
				answer = order;
				break;
			}else {
				list.remove(0);
				order++;
			}
		}
		// pop해서 꺼냈을때 check를 보고 -1이면 그때 순서 찍고 끝.

		System.out.println(answer);
		return answer;
	}
}
