package Level1;

public class 하샤드수 {
	   public boolean solution(int x) {
	        boolean answer = true;
	        char arr[] = Integer.toString(x).toCharArray();
	        int num = 0;
	        for(int i = 0 ; i < arr.length; i++){
	            num += arr[i]-'0';
	        }
	        answer = (x % num == 0)? true: false;
	        return answer;
	    }
}
