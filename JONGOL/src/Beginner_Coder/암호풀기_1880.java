package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호풀기_1880 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//복호화 키 26개 소문자 입력.
		char arr[] = in.readLine().toCharArray();
		
		//암호화된 문장 입력받아 배열로 바꿈.
		char msg[] = in.readLine().toCharArray();
		
		//원문 출력
		for (int i = 0; i < msg.length; i++) {
			
			//공백이면 그대로 출력
			if(msg[i] == ' ') {
				System.out.print(msg[i]);
				continue;
			} 
			
		    //대문자라면
			if(msg[i] < 97) {
				msg[i] += 32; //소문자로 바꾸고
				System.out.print((char)(arr[msg[i] - 97] - 32));
				continue;
			}
			
			//그냥 소문자일 경우
			System.out.print(arr[msg[i] - 97]);
			
			
		}
	}
}
