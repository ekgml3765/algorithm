package Level2;

public class 연습문제_124나라의숫자 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(true){
            int quo = n / 3;
            int remain = (n % 3 == 0)? 4 : n % 3;
            sb.append(remain);
            n = (remain == 4)? quo-1: quo;
            if(n == 0)
                break;
        }
        return sb.reverse().toString();
    }
}
