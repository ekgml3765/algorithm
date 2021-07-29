package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 가장큰수 {

	public static void main(String[] args) {
		int [] numbers = {3, 30, 34, 5, 9};
		solution(numbers);
	}
	 public static String solution(int[] numbers) {
	        String answer = "";
	        String arr[] = new String[numbers.length];
	        for (int i = 0; i < numbers.length; i++) {
				arr[i] = Integer.toString(numbers[i]);
			}       
	        Arrays.sort(arr, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					String s1 = o1+o2;
					String s2 = o2+o1;
					return Integer.parseInt(s2) - Integer.parseInt(s1);
				} 	
			});
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
	        answer = sb.toString();
	        if(answer.charAt(0) == '0')
	        	return "0";
	        System.out.println(answer);
	        return answer;
	    }
}
