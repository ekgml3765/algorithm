package Beginner_Coder;

import java.util.Scanner;

public class 별삼각형1_1523 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//에러처리 조건 주의*
		if( n > 100 || 1 > m || m > 3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		//종류 입력
		switch (m) {
		case 1:{
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
		case 2:{
			for (int i = n; i >= 0 ; i--) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
		case 3:{
			for (int i = 0; i < n; i++) { //높이만큼
				for (int j = i; j < n-1; j++) {
					System.out.print(" ");			
				}
				for (int k = 0; k < (2*i)+1 ; k++) { //* 찍기 홀수개만큼
					System.out.print("*");
				}
				System.out.println();
			}
			
			break;
		}
			
		}
	}
}
