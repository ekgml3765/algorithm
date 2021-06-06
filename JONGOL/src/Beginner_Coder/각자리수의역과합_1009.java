package Beginner_Coder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.ReverbType;

public class 각자리수의역과합_1009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String s = sc.next(); //string 으로 입력
			if(Integer.parseInt(s)  == 0) break;
			
			// 역수 구하기
			String s2 = new StringBuffer(s).reverse().toString(); //스트링버퍼 이용해 입력받은 string 역수로 바꿈.
			int num2 = Integer.parseInt(s2); 
			
			int sum = 0;
			for (int i = 0; i < s2.length(); i++) {
				sum += s2.charAt(i) - '0';
			}
			System.out.println( num2+ " " + sum);

				
		}
	}
}
