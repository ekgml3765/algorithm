package Level1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i ++){
            if(list.get(list.size()-1) == arr[i])
                continue;
            list.add(arr[i]);
        }
        int[] answer = new int [list.size()];
        int idx = 0;
        for(Integer i : list){
            answer[idx] = i;
            idx++;
        }
        return answer;
    }
}
