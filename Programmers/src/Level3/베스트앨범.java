package Level3;

import java.util.*;

class 베스트앨범 {
    static class Node implements Comparable<Node>{
        int id, cnt;
        public Node (int id, int cnt){
            this.id = id;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Node o){
            if(this.cnt == o.cnt){
                return this.id-o.id;
            }
            return o.cnt - this.cnt;
        }
    }
    static class Play{
        int sum;
        List<Node> list = new ArrayList<>();
    }
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> ans = new ArrayList<>();
        HashMap<String, Play> map = new HashMap<>();
        for(int i = 0 ; i < genres.length; i++){
            String key = genres[i];
            Play p;
            if(map.get(key) == null){
                p = new Play();        
            }else{
                p = map.get(key);
            }
             p.sum += plays[i];
             p.list.add(new Node(i, plays[i]));
             map.put(key, p);
        }
        //sum으로 정렬
        List<Map.Entry<String, Play>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Play>>() {
            @Override
            public int compare(Map.Entry<String, Play> o1, Map.Entry<String, Play> o2) {
                return o2.getValue().sum - o1.getValue().sum;
            }
        });
        
        for(Map.Entry<String, Play> entry : entryList){
            Play p = map.get(entry.getKey());
            Collections.sort(p.list);
            if(p.list.size() == 1){
                ans.add(p.list.get(0).id);
            }else{
                ans.add(p.list.get(0).id);
                ans.add(p.list.get(1).id);
            }
        }
        return ans;
    }
}