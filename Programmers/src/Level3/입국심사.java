package Level3;

import java.util.Arrays;

public class 입국심사 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long start = times[0];
        long end = (long)n * times[times.length-1];
        while(start <= end){
            long mid = (start + end) / 2;
            long sum = 0; //인원수
            for(int i = 0; i < times.length; i++){
                sum += (mid / times[i]);
            }
            if(sum < n){
                start = mid + 1;
            }else{
                answer = mid;
                end = mid - 1;
            }
        }
        return answer;
    }
}
