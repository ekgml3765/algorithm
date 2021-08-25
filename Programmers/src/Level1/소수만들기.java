package Level1;

public class 소수만들기 {
	   static int sel[], ans =0;
	    public int solution(int[] nums) {
	        sel = new int [3];
	        comb(0, 0, nums);
	        return ans;
	    }
	    public static void comb (int idx, int s_idx, int[] nums){
	        if(s_idx == 3){
	            int num = 0;
	            for(int i = 0; i < sel.length; i++){
	                num += sel[i];
	            }
	            if(check(num)){
	                ans++;
	            }
	            return;
	        }
	        if(idx == nums.length)
	            return;
	        sel[s_idx] = nums[idx];
	        comb(idx+1, s_idx+1, nums);
	        comb(idx+1, s_idx, nums);
	    }
	    public static boolean check(int num){
	        if(num == 1)
	            return false;
	        for(int i = 2; i <= Math.sqrt(num); i++){
	            if(num%i == 0)
	                return false;
	        }
	        return true;
	    } 
	    
}
