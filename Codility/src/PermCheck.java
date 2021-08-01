 import java.util.*;

class PermCheck {
    public int solution(int[] A) {
        int ans = 1;
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            if(A[i] != i+1){
                return 0;
            }
        }
        return ans;
    }
}