package Level1;

public class 삼진법뒤집기 {
	public int solution(int n) {
		String s = Integer.toString(n, 3);
		StringBuilder sb = new StringBuilder(s);
		return Integer.parseInt(sb.reverse().toString(), 3);
	}
}
