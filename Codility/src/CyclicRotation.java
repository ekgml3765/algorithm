import java.util.Arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		int[] A = { 3, 8, 9, 7, 6 };
		int K = 3;
		solution(A, K);
	}

	public static int[] solution(int[] A, int K) {
		int ans[] = new int[A.length];
		for (int i = 0; i < ans.length; i++) {
			ans[(i+K)%A.length] = A[i];
		}
		return ans;
	}

}
