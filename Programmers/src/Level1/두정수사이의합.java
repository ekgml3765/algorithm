package Level1;

public class 두정수사이의합 {

    public long solution(int a, int b) {
        long answer = 0;
        if(a==b)
            return a;
        int min = Math.min(a,b);
        int big = Math.max(a,b);
        for(int i = min; i <= big; i++){
            answer += i;
        }
        return answer;
    }
}
