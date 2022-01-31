package Level1;

import java.util.*;

public class 카카오_2022_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> nameList = new HashMap<>();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            nameList.put(id_list[i], i);
        }
        for(int i = 0 ; i < report.length; i++){
            String arr[] = report[i].split(" ");
            map.computeIfAbsent(arr[1], s -> new HashSet<>()).add(arr[0]);
        }
        for(String key: map.keySet()){
            HashSet<String> set = map.get(key);
            if(set.size() >= k){
             String list[] = set.toArray(new String[set.size()]);
                for(String s : list){
                    answer[nameList.get(s)]++;
                }
            }
        }
        return answer;
    }
}
