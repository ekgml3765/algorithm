package Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 나누어떨어지는숫자배열 {
	public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < arr.length; i ++){
            if(arr[i]%divisor == 0)
                list.add(arr[i]);
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        if(list.size()==0){
            return new int[] {-1};
        }
        int idx = 0;
        for(Integer i : list){
            answer[idx] = i;
            idx++;
        }
        return answer;
    }
}
