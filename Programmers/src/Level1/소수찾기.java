package Level1;

public class 소수찾기 {
    public int solution(int n) {
        int answer = 0;
        out: for(int i = 2; i <= n ; i ++){
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i%j == 0)
                    continue out;
            }
            answer++;
        }
        return answer;
    }
}
