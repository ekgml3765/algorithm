package Level2;

import java.util.StringTokenizer;

public class 최댓값과최솟값 {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        String answer = "";
        answer = min + " " + max; 
        return answer;
    }
}
