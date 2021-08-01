import java.util.*;

class MaxCounters {
    public int[] solution(int N, int[] A) {
        int max = 0;
        int plus = 0;
        int counter[] = new int[N];
        for(int i = 0 ; i < A.length; i++){
            if(A[i] == N+1){
               //초기화
               plus = max;
               continue;
            }else{
                int num = 0;
                if(counter[A[i]-1] < plus){
                    counter[A[i]-1] = plus;
                    num = ++counter[A[i]-1];
                }else{
                    num = ++counter[A[i]-1];
                }
                 max = Integer.max(max, num);    
            }
        }
        for(int i = 0; i < counter.length; i++){
            if(counter[i] < plus)
                counter[i] = plus;
        }
        return counter;
    }
}