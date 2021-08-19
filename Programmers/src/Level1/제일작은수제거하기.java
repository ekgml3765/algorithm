package Level1;

public class 제일작은수제거하기 {
	   public int[] solution(int[] arr) {
	        int[] answer = new int [arr.length-1];
	        int idx = 0;
	        int min = Integer.MAX_VALUE;
	        for(int i = 0 ; i < arr.length; i++){
	            if(arr[i] < min){
	                min = arr[i];
	                idx = i;
	            }
	        }
	        int j = 0;
	        for(int i = 0; i < arr.length; i++){
	            if(idx == i)
	                continue;   
	            answer[j] = arr[i];
	            j++;
	        }
	        if(answer.length == 0){
	            answer = new int[1];
	            answer[0] = -1;
	        }
	        return answer;
	    }
}
