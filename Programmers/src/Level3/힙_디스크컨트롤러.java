package Level3;

import java.util.*;
class 힙_디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int sum = 0;
        int end = 0;
        int idx = 0;
        int cnt = 0;
        while(cnt < jobs.length ){
            
            while(idx < jobs.length && jobs[idx][0] <= end){
                pq.add(jobs[idx++]);
            }
            
            if(pq.isEmpty()){
                end = jobs[idx][0];
            }else{
                int tmp[] = pq.poll();
                end += tmp[1];
                sum += end-tmp[0];
                cnt++;
            }
        }
        answer = sum / jobs.length;
        return answer;
    }
}