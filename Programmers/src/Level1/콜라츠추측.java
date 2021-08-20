package Level1;

public class 콜라츠추측 {

    public int solution(int num) {
        int answer = -1;
        long number = (long)num;
        for(int i = 0 ; i < 500; i++){
            if(number == 1){
                answer = i;
                break;
            }
            if(number % 2 == 0){
                number /= 2;
            }else{
                number = (number*3)+1;
            }       
        }
        return answer;
    }
}
