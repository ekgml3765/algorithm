
 import java.util.*;

class Dominator {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        double size = A.length / 2.0;
        for(int i = 0; i < A.length; i++){
            map.put(A[i], map.getOrDefault(A[i],0)+1);
            if(map.get(A[i]) > size)
                return i;
        }
        return -1;
    }
}