package Beginner_Coder;

import java.util.Scanner;

public class 문자사각형1_1307 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		char arr[][] = new char[n][n];

		int num = 65;
		// 값 넣기
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (num > 90) {
					num = 65;
				}
				arr[j][i] = (char) num;
				num++;
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
