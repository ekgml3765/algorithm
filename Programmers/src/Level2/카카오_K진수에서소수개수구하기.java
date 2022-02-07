package Level2;
import java.util.*;

class Solution {
    static int ans = 0;
    public int solution(int n, int k) {
        String s = Integer.toString(n, k);
        String arr[] = s.split("0");
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(""))
                continue;
            if(check(Long.parseLong(arr[i])))
                ans++;
        }
        return ans;
    }
    public static boolean check(long num){
        if(num == 1)
            return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
