package Level1;

public class 문자열다루기기본 {

	public boolean solution(String s) {
		int size = s.length();
		s = s.replaceAll("[0-9]", "");
		return (s.length() == 0 && (size == 4 || size == 6)) ? true : false;
	}
}
