
import java.util.*;


class CountDiv {
    public int solution(int A, int B, int K) {
       int ans = 0;
       int end = B/K;
       int start = A/K;
       if(A%K == 0)
         ans = end - start + 1;
        else
            ans = end - start;
       
       return ans;
    }
}