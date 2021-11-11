package Level1;

import java.util.Arrays;
import java.util.Collections;

class 숫자뽑기 {
    public int solution(int[] arr, int K) {
        // 여기에 코드를 작성해주세요.
        int answer = Integer.MAX_VALUE;
        Integer[] list = new Integer[arr.length];
        for(int i = 0 ; i < arr.length; i++)
            list[i] = arr[i];
        //정렬
        Arrays.sort(list, Collections.reverseOrder());
       // System.out.println(Arrays.toString(list));
        //K범위까지해서 차이계산
        for(int i = 0; i <= list.length-K; i++){
            int b = list[i];
            int a = list[i+K-1];
           // System.out.println(Math.abs(b-a));
            answer = Math.min(answer, Math.abs(b-a));
        }

        return answer;
    }
}