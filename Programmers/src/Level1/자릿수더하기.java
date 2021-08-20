package Level1;

public class 자릿수더하기 {

	  public int solution(int n) {
	        int answer = 0;
	        char arr[] = Integer.toString(n).toCharArray();
	        for(char c : arr){
	            answer += c - '0';
	        }
	        return answer;
	    }
}
