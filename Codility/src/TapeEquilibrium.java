
public class TapeEquilibrium {

	public static void main(String[] args) {
		int A[] = {3,1,2,4,3};
		solution(A);
	}

	public static int solution(int[] A) {
		int ans = Integer.MAX_VALUE;
		int sum2 = 0;
		for (int i = 0; i < A.length; i++) {
			sum2+= A[i];
		}
		int sum1 = 0;
		for (int p = 1; p < A.length; p++) {
			sum1 += A[p-1];
			sum2 -= A[p-1];
			ans = Math.min(ans, Math.abs(sum1-sum2));
		}
		return ans;
	}
}
