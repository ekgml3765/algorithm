package Level1;

public class 평균구하기 {
	 public double solution(int[] arr) {
	        double sum = 0;
	        int cnt = 0;
	        for(int i = 0 ; i < arr.length; i ++){
	            sum += arr[i];
	            cnt++;
	        }
	        return sum/cnt;
	    }
}
