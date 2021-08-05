import java.util.*;

class CountFactors {
    public int solution(int N) {
        int ans = 0;
        int num = (int) Math.sqrt(N);
        for(int i = 1; i <= num; i++){
            if(N%i == 0){//나누어 떨어지면
                if(N/i == i)
                    ans+=1;
                else   
                    ans+=2;
            }
        }
        return ans;
    }
}