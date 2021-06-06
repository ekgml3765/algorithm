package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 진법변환 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			if(A == 0) break; // 0이면 끝
			
			String n = st.nextToken();
			int B = Integer.parseInt(st.nextToken());
			
		
			
			//받은 숫자를 10진수로 변환
			long num = 0;
			for (int i = 0; i < n.length(); i++) {
				if(n.charAt(i) <= '9') {
					
					num += (long) Math.pow(A, (n.length() - 1 - i)) * (n.charAt(i) - '0');
					System.out.println(num);
				}
				// 10이상이면 알파벳을 숫자로 바꿔준 후 계산
				else {
					num += (long) Math.pow(A, (n.length() - 1 - i)) * (n.charAt(i) - 55);
					System.out.println(num);
				}	
			}
			
			System.out.println(num);
			
			// num을 해당 진법으로 변환
			long quo = num, rest = 0; // 몫
			StringBuilder sb = new StringBuilder();
			
		
			while (quo != 0) {
				// 나머지 담음
				rest = quo % B;
				if(rest <= 9) sb.append(rest);
				else {
			
					sb.append((char) (rest+55));
				}
				quo = quo / B;
			}

			// 0 예외처리
			if(sb.length() == 0 ) {
				System.out.println(0);
				continue;
			}
			
			sb.reverse();
			System.out.println(sb.toString());
		
			
		}	
	}
}
