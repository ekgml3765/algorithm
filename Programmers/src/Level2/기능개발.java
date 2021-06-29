package Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int progresses[] = { 95, 90, 99, 99, 80, 99 };
		int speeds[] = { 1, 1, 1, 1, 1, 1 };
		solution(progresses, speeds);
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < progresses.length; i++) {
			double day = (double) (100 - progresses[i]) / speeds[i];
			if (day - (int) day > 0)
				day += 1;
			queue.add((int) day);
		}

		List list = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			int first = queue.poll(); // 첫번째 꺼냄
			int cnt = 1;
			while (!queue.isEmpty()) {
				int temp = queue.peek();
				if (first >= temp) {
					queue.poll();
					cnt++;
					continue;
				}
				break;
			}
			list.add(cnt);
		}

		answer = new int [list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = (int) list.get(i);
		}
		//System.out.println(list.toString());
		return answer;
	}
}
