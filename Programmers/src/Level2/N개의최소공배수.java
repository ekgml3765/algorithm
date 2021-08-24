package Level2;

public class N개의최소공배수 {
	  public int solution(int[] arr) {
	        if(arr.length == 1){
	            return arr[0];
	        }
	        int a = arr[0];
	        int gcd = 0;
	        for(int i = 1; i < arr.length; i++){
	            int b = arr[i];
	            for(int j = a*b; j > 0; j--){
	                if((j%a == 0) && (j%b == 0))
	                    gcd = j;
	            }
	            a = gcd;
	        }
	        return gcd;
	    }
}
