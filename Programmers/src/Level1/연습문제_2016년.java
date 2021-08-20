package Level1;

public class 연습문제_2016년 {
    public String solution(int a, int b) {
        int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String day[] = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int date = 0;
        for(int i = 1; i < a; i++){
            date+= month[i-1];
        }
        date += b;
        return day[date%7];
    }	
}
