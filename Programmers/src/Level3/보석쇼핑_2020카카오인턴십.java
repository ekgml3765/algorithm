package Level3;

import java.util.HashMap;
import java.util.HashSet;

public class 보석쇼핑_2020카카오인턴십 {
    public int[] solution(String[] gems) {
        int size = 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < gems.length; i++){
            set.add(gems[i]);
        }
        size = set.size();
        //가장 짧은 구간 찾기
        HashMap<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
        //풀이 1
        while(start < gems.length){
            if(map.size() == size || end == gems.length){
                if(map.size() == size && len > end-start){
                    len = end-start;
                     ans1 = start+1;
                     ans2 = end;
                }
                int val = map.get(gems[start]);
                if(val == 1)
                     map.remove(gems[start]);
                else
                    map.put(gems[start], val-1);
                start++;  
            }else{
                map.put(gems[end], map.getOrDefault(gems[end], 0)+1);
                end++;   
            }
        }
        //풀이 2
        // while(start < gems.length){           
        //     while( map.size() < size && end < gems.length){
        //         map.put(gems[end], map.getOrDefault(gems[end], 0)+1);
        //         end++;
        //     }
        //     if(map.size() == size){
        //         if(len > end-start){
        //             len = end-start;
        //             ans1 = start+1;
        //             ans2 = end;
        //         }
        //     }          
        //     int val = map.get(gems[start]);
        //     if(val == 1)
        //          map.remove(gems[start]);
        //     else
        //         map.put(gems[start], val-1);
        //     start++;        
        // }
        return new int[]{ans1, ans2};
    }
}
