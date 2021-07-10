package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class n진수게임 {

	public static void main(String[] args) {
		int n = 2; // 진법
		int t = 4; // 구할 숫자의 갯수
		int m = 2; // 참가 인원
		int p = 1; // 튜브의 순서	
		solution(n, t, m, p);
	}

	public static String solution(int n, int t, int m, int p) {
		String answer = "";
		String s = "0123456789ABCDEF";
		int[] tube = new int[t];
		//튜브 순서 배열
		for (int i = p - 1, j = 0; j < t; j++, i += m) {
			tube[j] = i;
		}
		
		// n진법으로 t*m까지 만들기
		List<Character> list = new ArrayList<Character>();
		list.add('0');
		for (int i = 1; i < t*m; i++) {
			List<Character> number = new ArrayList<Character>();
			int quo = i; // 몫
			while (quo != 0) {
				number.add(s.charAt(quo % n));
				quo /= n;
			}
			Collections.reverse(number);
			list.addAll(number);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tube.length; i++) {
			sb.append(list.get(tube[i]));
		}
		answer = sb.toString();
		return answer;
	}
}
