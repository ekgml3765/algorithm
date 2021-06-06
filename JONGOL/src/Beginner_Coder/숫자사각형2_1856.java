package Beginner_Coder;

import java.util.Scanner;

public class 숫자사각형2_1856 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 사각형의 높이n
		int m = sc.nextInt(); // 사각형의 너비 m

		int number = 1;
		int temp = 0; //홀수행 시작점 관리할 변수
		for (int i = 0; i < n; i++) { // n행 만큼 반복
			if (i % 2 == 1) { // 행이 홀수행일 경우
				temp = number + m -1; //홀수행 시작 수
				number = number+m; //짝수행 시작수
			}
			for (int j = 0; j < m; j++) { // m열 만큼 반복
				if(i%2 == 1) { //홀수행일때
					System.out.print(temp + " ");
					temp--;
					continue;
				}
				System.out.print(number + " ");
				number++;

			}
			System.out.println(); // 줄바꿈
		}
	}

}
