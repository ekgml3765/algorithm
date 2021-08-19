package Level1;

class 위클리챌린지_1주차 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        for(int i = 1; i <= count; i++){
            long num = price*i;
            sum += num;
        }
        answer = (sum-money <= 0)? 0 : sum-money;
        return answer;
    }
}