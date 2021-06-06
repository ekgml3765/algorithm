package Beginner_Coder;

import java.util.Scanner;

public class 그릇_2604 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String s = sc.next(); //스트링으로 입력
		char ch[] = s.toCharArray(); // string -> 문자열 배열
		
		int height = 10; //그릇 처음 바닥에 놓을때 10cm이므로 초기화
		
		//첫번째 그릇은 이미 높이를 세었으므로 2번째 그릇부터
		for (int i = 1; i < ch.length; i++) {
			if(ch[i] == ch[i-1]) height += 5; //i번째 그릇과 그 앞그릇 모양 같으면 +5
			else height += 10; //모양 다르면 +10
		}
		
		System.out.println(height);
	}
}
