package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 전화번호목록 {

	public static void main(String[] args) {
		String[] phone_book = {"12","2"};
		solution(phone_book);
	}
	
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				answer = false;
				break;
			}	
		}
        System.out.println(answer);
        return answer;
    }
}
