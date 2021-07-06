package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 문자열압축 {

	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";
		solution(s);
		System.out.println(ans);
	}

	static int ans;

	public static int solution(String s) {
		int answer = 0;
		ans = s.length();
		if (ans == 1)
			return 1;
		int size = s.length() / 2; // 최대한 나눌 수 있는 단위
		slice(size, s);
		answer = ans;
		return answer;
	}

	// 단위로 쪼개기
	private static void slice(int size, String s) {

		for (int i = 1; i <= size; i++) {
			List<String> words = new ArrayList<String>();
			int start = 0;
			int end = start + i;
			while (end <= s.length()) {
				String t = s.substring(start, end);
				words.add(t);
				start = end;
				end = start + i;
			}
			// 나머지 처리
			if (start < s.length()) {
				words.add(s.substring(start, s.length()));
			}
			StringBuilder sb = new StringBuilder();
			// 단위대로 생성된 배열로 새로운 단어 만들기
			int num = 1;
			for (int j = 0; j < words.size() - 1; j++) {
				if (!words.get(j).equals(words.get(j + 1))) {
					if (num > 1) {
						sb.append(num);
						num = 1;
					}
					sb.append(words.get(j));
					if (j == words.size() - 2)
						sb.append(words.get(j + 1));
					continue;
				} else {
					num++;
					if (j == words.size() - 2) {
						sb.append(num);
						sb.append(words.get(j + 1));
					}
				}
			}
			ans = Math.min(ans, sb.length());
		}

	}
}
