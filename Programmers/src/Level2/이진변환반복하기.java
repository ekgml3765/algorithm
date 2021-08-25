package Level2;

public class 이진변환반복하기 {
	public int[] solution(String s) {
		int[] answer = new int[2];
		while (!s.equals("1")) {
			int size = s.length();
			s = s.replaceAll("0", "");
			int newSize = s.length();
			answer[1] += size - newSize;
			s = Integer.toString(newSize, 2);
			answer[0]++;
		}
		return answer;
	}
}
