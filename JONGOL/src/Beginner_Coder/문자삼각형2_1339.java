package Beginner_Coder;

import java.util.Scanner;

public class 문자삼각형2_1339 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char arr[][] = new char[n + 1][n + 1];
		
		//입력 범위 아웃시
		if(n % 2 == 0 || n <= 0  || n > 100) {
			System.out.println("INPUT ERROR");
			return;
		}
		
		char c = 'A';
		int cnt = (n / 2) + 1; //시작점은 정 가운데.
		
	
		// 값 넣기
		for (int i = cnt, k = 1; i > 0; i--, k +=2) { // k = 1, 3, 5, 7, .. 홀수
			for (int j = i; j < i+k ; j++) {  
			arr[j][i] = c++; //열고정 행 변화. j가 변화 
			if(c > 'Z') c = 'A';
			}	
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
