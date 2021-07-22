import java.util.Arrays;

public class PermMissingElem {

	public static void main(String[] args) {
		int A[] = {2,3,1,4};
		solution(A);
	}

	public  static int solution(int[] A) {
		int ans = 0;
		Arrays.sort(A);
		boolean flag = true;
		for (int i = 0; i < A.length; i++) {
			if(i+1 != A[i]) {
				ans = i+1;
				flag = false;
				break;
			}
		}
		if(flag)
			ans = A.length+1;
		return ans;
	}
}
