import java.util.Arrays;

public class FrogRiverOne {

	public static void main(String[] args) {
	}
	
	 public int solution(int X, int[] A) {
	       int ans = -1;
	       //1. 해당 위치에 제일 빠르게 도착하는 초 기록
	       int time [] = new int [X+1];
	       for(int i = 0; i < time.length; i++){
	           time[i] = -1;
	       }
	       for(int i = 0; i < A.length; i++){
	           if(time[A[i]] == -1){
	               time[A[i]] = i;
	           }
	       }
	       //System.out.println(Arrays.toString(time));
	       //2. 칸 검사
	       Arrays.sort(time);
	       for(int i = 1 ; i < time.length; i++){
	           if(time[i] == -1)
	                return ans;
	       }
	       ans = time[time.length-1];
	       return ans;
	    }
	
}
