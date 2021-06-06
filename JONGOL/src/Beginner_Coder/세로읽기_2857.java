package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기_2857 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char arr[][] = new char [5][15];
		
		//5줄 입력
		for (int i = 0; i < 5; i++) {
			String s = in.readLine();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j);
			}
		} 

		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(arr[j][i] == '\0') continue;
				System.out.print(arr[j][i]);
			}
		}
	}
}
