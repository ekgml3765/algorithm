package Level2;

public class 위클리챌린지_5주차 {
	static String arr[] = { "A", "E", "I", "O", "U" };
	static int cnt = 0, ans = 0;
	public int solution(String word) {
		perm(0, "", word);
		return ans;
	}
	private static void perm(int idx, String s, String word) {
		if (idx == 5)
			return;
		for (int i = 0; i < arr.length; i++) {
			String ss = s + arr[i];
			cnt++;
			if (ss.equals(word)) {
				ans = cnt;
				return;
			}
			perm(idx + 1, ss, word);
		}
	}
}
