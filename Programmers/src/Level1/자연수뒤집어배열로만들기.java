package Level1;

public class 자연수뒤집어배열로만들기 {

	   public int[] solution(long n) {
	        String s = Long.toString(n);
	        int[] answer = new int[s.length()];
	        for(int i = s.length()-1, j = 0; i >= 0 ; i --, j++){
	            answer[j] = s.charAt(i)-'0';
	        }
	        return answer;
	    }
}
