package Level2;

import java.util.HashSet;

import java.util.HashSet;

public class 영어끝말잇기 {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int number = 1;
		int turn = 1;
		boolean flag = false;
		HashSet<String> set = new HashSet<String>();
		char last = words[0].charAt(0);
		for (int i = 0; i < words.length; i++) {
			String s = words[i];
			if (set.contains(s) || s.charAt(0) != last) {
				answer[0] = number;
				answer[1] = turn;
				break;
			}
			last = s.charAt(s.length() - 1);
			set.add(s);
			number++;
			if (number > n) {
				number = 1;
				turn++;
			}
		}
		return answer;
	}
}
