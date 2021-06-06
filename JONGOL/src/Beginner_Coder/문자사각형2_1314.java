package Beginner_Coder;

import java.util.Scanner;

public class 문자사각형2_1314 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		char arr[][] = new char[n][n];

		char c = 'A';
		// 값 넣기
		for (int i = 0; i < n ; i++) { // n번 반복
			if( i % 2 == 1) {//홀수행 일 경우
				for (int j = n-1; j >= 0; j--) {
					arr[j][i] = c;
					c++;
					if(c > 'Z') c = 'A';
				}
				continue;
			}
			//짝수행
			for (int j = 0; j < n; j++) {
				arr[j][i] = c;
				c++;
				if(c > 'Z') c = 'A';
			}
		}

		// 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
