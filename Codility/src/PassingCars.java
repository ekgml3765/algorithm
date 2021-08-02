
import java.util.*;

class PassingCars {
    public int solution(int[] A) {
        int ans = -1;
        int oneCnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = A.length-1; i >= 0 ; i--){
            if(A[i] == 0){
                list.add(oneCnt);
                oneCnt = 0;
            }else{
                oneCnt ++;
            }
        }
        if(list.size() == 0) //0을 못 만남
            return 0;
        long answer = 0;
        long sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum+= list.get(i);
            answer += sum;
        }
        if(answer > 1000000000)
            ans = -1;
        else 
            ans = (int) answer;
        return ans;
    }
}