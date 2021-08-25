package Level2;

public class 다음큰숫자 {
    public int solution(int n) {
        int answer = n+1;
        int cnt = Integer.bitCount(n); // n -> bit -> 1의 숫자를 세줌
        while(true){
            if(cnt == Integer.bitCount(answer))
                break;
            answer++;
        }
        return answer;
    }
}
