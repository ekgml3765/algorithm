package Level1;

public class 정수제곱근판별 {

    public long solution(long n) {
        long answer = -1;
        double num = Math.sqrt(n);
        if(num - (int)num == 0)
            answer = (long) Math.pow(num+1,2);
        return answer;
    }
}
