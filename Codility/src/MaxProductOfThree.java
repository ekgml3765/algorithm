
import java.util.*;

class Solution {
    public int solution(int[] A) {
        int ans = 0;
       List<Integer> minus = new ArrayList<>();
       List<Integer> plus = new ArrayList<>();
       Arrays.sort(A);
       for(int i = 0; i < A.length; i++){
           if(A[i] < 0)
             minus.add(A[i]);
           else
             plus.add(A[i]);
       }
       if(minus.size() < 2 || plus.size() == 0) //음수가 2개미만, 양수가 하나도 없을때 
            ans = A[A.length-1]*A[A.length-2]*A[A.length-3];
        else{
            int num = minus.get(0)*minus.get(1)*plus.get(plus.size()-1);
            int num2 = A[A.length-1]*A[A.length-2]*A[A.length-3];
            ans = Math.max(num,num2);
        }
        return ans;
    }
}