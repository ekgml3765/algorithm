
import java.util.*;

class MissingInteger {
    public int solution(int[] A) {
        int ans = 1;
        int arr[] = new int[1000001];
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            if(A[i] > 0)
                arr[A[i]]++;
        }
        for(int i = 1; i <= arr.length; i++){
            if(arr[i] == 0){
                ans = i;
                break;
            }
        }
        return ans;
    }
}