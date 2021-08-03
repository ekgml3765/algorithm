
import java.util.*;

class Triangle {
    public int solution(int[] A) {
        int ans = 0;
       
        if(A.length < 3)
            return 0;
        Arrays.sort(A); 
        for(int i = 0; i <= A.length-3; i++){
            long a = A[i];
            long b = A[i+1];
            long c = A[i+2];
            if(a+b > c && a+c > b && b+c > a)
                return 1;   
        }
        return ans;
    }
}