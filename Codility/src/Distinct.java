
import java.util.*;

class Distinct {
    public int solution(int[] A) {
        int ans = 0;
        HashSet<Integer>set = new HashSet<Integer>();
        for(int i = 0 ; i < A.length; i++){
            set.add(A[i]);
        }
        ans = set.size();
        return ans;
    }
}