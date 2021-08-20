package Level1;

public class 이상한문자만들기 {

	public static void main(String[] args) {
		String s = "a b c    ";
		s = s.toLowerCase();
		String sarr[] = s.split(" ", -1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sarr.length; i++) {
			for (int j = 0; j < sarr[i].length(); j++) {
				char c = sarr[i].charAt(j);
				if (j % 2 == 0) {
					c -= 32;
				}
				sb.append(c);
			}
			sb.append(" ");
		}
		String answer = sb.toString();
		System.out.println(answer.substring(0, answer.length()-1));
	}
}
