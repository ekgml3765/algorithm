package Level1;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {
	 public String solution(String s) {
	        char arr[] = s.toCharArray();
	        Arrays.sort(arr);
	        StringBuilder sb = new StringBuilder(new String(arr,0,arr.length));
	        return sb.reverse().toString();
	    }
}
