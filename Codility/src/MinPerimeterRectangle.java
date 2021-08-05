import java.util.*;

class MinPerimeterRectangle {
    public int solution(int N) {
        int ans = Integer.MAX_VALUE;
        int size = (int) Math.sqrt(N);
        for(int i = 1; i <= size; i++){
            if(N%i == 0){
                int a = i;
                int b = N/i;
                int num = 2*(a+b);
                ans = Math.min(num, ans);
            }
        }
        return ans;
    }
}