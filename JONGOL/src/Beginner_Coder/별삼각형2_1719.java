package Beginner_Coder;

import java.util.Scanner;

public class 별삼각형2_1719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//에러처리 조건 주의*
		if( n > 100 || n%2 == 0 || 1 > m || m > 4) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		//종류 입력
		switch (m) {
		case 1:{
			int c = 0;
			for (int i = 1, j = n; i <= n ; i++, j--) {
				if(i <= n/2) c = i;
				else c = j;
				for (int k = 0; k < c; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
		case 2:{
			
			int c = 0, b = (n/2) +1 ;
			for (int i = 1, j = n; i <= n ; i++, j--) {
				if(i <= n/2) c = i;
				else c = j;
				//공백추가
				for (int d = 0; d < b-c; d++) {
					System.out.print(" ");
				}
				for (int k = 0; k < c; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
		case 3:{

			int c = 0 ;
			for (int i = 0, j = n-1; i < n ; i++, j--) {
				if(i <= n/2) c = i;
				else c = j;
				//공백추가
				for (int d = 0; d < c; d++) {
					System.out.print(" ");
				}
				for (int k = 0; k < (-2 *c) + n; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
		
		case 4:{
			
			break;
		}
			
		}
	}
}
