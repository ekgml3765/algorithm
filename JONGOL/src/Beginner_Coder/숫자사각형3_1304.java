package Beginner_Coder;

import java.util.Scanner;

public class 숫자사각형3_1304 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정사각형 한 변의 길이 n
		
		int arr[][] = new int[n][n];
		int number = 1;
		// 값 넣기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[j][i] = number++;
			}
		}
		//출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
