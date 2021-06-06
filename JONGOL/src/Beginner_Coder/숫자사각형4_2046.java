package Beginner_Coder;

import java.util.Scanner;

public class 숫자사각형4_2046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //정사각형 한 변의 길이
		int m = sc.nextInt(); //종류
		
		//인덱스 1부터 넣기 위해 배열크기 1크게
		int arr1[][] = new int [n+1][n+1]; //종류1 담을 배열
		int arr2[][] = new int [n+1][n+1]; //종류 2
		int arr3[][] = new int [n+1][n+1]; //종류 3
		
		//값 넣기
		for (int i = 1; i <= n ; i++) {
			int val = i;
			int c = n; 
			for (int j = 1; j <= n ; j++, val+=i) {
				arr1[i][j] = i; //종류 1은 i행 값
				arr3[i][j] = val; //종류 3은 val + i값
				if( i % 2 == 0) { //종류 2는 짝수일 경우 거꾸로 출력.
					arr2[i][j] = c--;
					continue;
				}
				arr2[i][j] = j;
			}
		}
		
		//배열 출력
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= n ; j++) {
				if(m==1) {
					System.out.print( arr1[i][j]+ " ");
				}
				else if(m==2) {
					System.out.print(arr2[i][j] + " ");
				}else {
					System.out.print( arr3[i][j]+ " ");
				}
			}
			System.out.println();
		}
		
		
	
	}
}
