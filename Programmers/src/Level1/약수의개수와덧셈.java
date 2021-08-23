package Level1;

public class 약수의개수와덧셈 {
	public int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			int cnt = 0;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					if (i / j == j) {
						cnt++;
					} else {
						cnt += 2;
					}
				}
			}
			answer += (cnt % 2 == 0) ? i : -i;
		}
		return answer;
	}
}
