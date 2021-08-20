package Level1;

public class 최대공약수와최소공배수 {

	  public int[] solution(int n, int m) {
	        int[] answer = new int[2];
	        int small = (n <= m)? n:m;
	        for(int i = 1 ; i <= small; i++){
	            if(n%i == 0 && m%i==0)
	                answer[0] = i;
	        }
	        answer[1] = n*m / answer[0];
	        return answer;
	    }
}
