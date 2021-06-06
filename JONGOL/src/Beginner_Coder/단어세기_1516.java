package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단어세기_1516 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st;
			String s = in.readLine();
			if(s.equals("END")) break; //END 만나면 끝
			
			st = new StringTokenizer(s,  " "); //공백기준 단어 끊어 읽음
			int size = st.countTokens(); // token(단어)수  = 배열사이즈 크기
			
			String s_array[] = new String[size]; //문장 안 단어 담을 스트링 배열
			
			for (int i = 0; i < size ; i++) {
				s_array[i] = st.nextToken();
			}
			
			//오름차순 후 갯수세기.
			Arrays.sort(s_array);
			
			int idx = 0, cnt = 1; 
			for (int i = 1; i < s_array.length; i++) {
				if(!s_array[idx].equals(s_array[i]))  { //서로 다른 단어 발견시
					System.out.println(s_array[idx] + " " + ":" + " " + cnt);
					idx = i;
					cnt = 1;// 횟수 초기화
					continue;
				}
				cnt++;
			}
			//마지막 단어 출력
			System.out.println(s_array[idx] + " " + ":" + " "+ cnt);
			
		}
	
	}
}
