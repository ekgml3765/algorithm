package Beginner_Coder;

import java.util.Scanner;

public class 숫자사각형1_1303 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(); //사각형의 높이n
		int m = sc.nextInt(); //사각형의 너비 m
		
		int number = 1;
		for (int i = 0; i < n; i++) { //n행
			for (int j = 0; j < m; j++) { //m열
				System.out.print(number + " ");
				number++;
			}
			System.out.println();
		}
	}

}
