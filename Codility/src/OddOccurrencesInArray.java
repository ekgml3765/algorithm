import java.util.Arrays;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int A[] = { 9, 3, 9, 3, 9, 7, 9 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int ans = 0;
		Arrays.sort(A);// 오름차순 정렬
		int num = A[0];
		int cnt = 1;
		for (int i = 1; i < A.length; i++) {
			if (num == A[i])
				cnt++;
			else {
				if (cnt % 2 != 0) {
					ans = A[i - 1];
					return ans;
				}
				num = A[i];
				cnt = 1;
			}
		}
		if( cnt%2 != 0)
			ans = A[A.length-1];
		return ans;
	}
}
