package Level2;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pqueue.add(scoville[i]);
        }
        while(!pqueue.isEmpty()){
            int first = pqueue.poll();
            if(first >= K)
                break;
            if(pqueue.isEmpty())
                return -1;
            else{
                int second = pqueue.poll();
                answer++;
                pqueue.add(first + (second * 2));
            }
        }
        return answer;
    }
}
