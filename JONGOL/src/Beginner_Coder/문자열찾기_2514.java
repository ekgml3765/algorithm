package Beginner_Coder;

import java.util.Scanner;

public class 문자열찾기_2514 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String s = sc.next();
		StringBuilder sb;
		int koi_cnt = 0; // KOI 카운트 변수
		int ioi_cnt = 0; // IOI 카운트 변수
		
		for (int i = 0; i < s.length()-2; i++) {
			sb = new StringBuilder(); //스트링빌더 생성
			for (int j = i; j < i+3; j++) {
				sb.append(s.charAt(j)); // 현재 i번째에서 3자리씩 더함
			}
			if(sb.toString().equals("KOI")) koi_cnt ++; //만들어진 글자가 KOI이면  카운트+1
			if(sb.toString().equals("IOI")) ioi_cnt ++; // IOI이면 카운트 +1
		}
		
		System.out.println(koi_cnt);
		System.out.println(ioi_cnt);
	}
}
