package Beginner_Coder;

import java.util.Scanner;

public class 문자삼각형1_1338 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		char arr[][] = new char[n + 1][n + 1];

		char c = 'A';
		int k = 1;
		// 값 넣기
		for (int i = 1; i <= n; i++) { // n번 반복
			int r = i;
			for (int j = n; j >= k; j--) {
				arr[r][j] = c;
				c++;
				r++;
				if(c > 'Z') c = 'A';
			}
			k++;
		}

		// 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(arr[i][j] == '\0') arr[i][j] = ' '; // ** 널값 처리 주의하기!
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
