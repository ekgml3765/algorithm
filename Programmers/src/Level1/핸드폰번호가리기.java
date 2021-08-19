package Level1;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        String answer = phone_number.substring(phone_number.length()-4,phone_number.length());
        String star = "";
        for(int i = 0; i < phone_number.length()-4; i++){
            star += "*";
        }
        return star+answer;
    }
}
