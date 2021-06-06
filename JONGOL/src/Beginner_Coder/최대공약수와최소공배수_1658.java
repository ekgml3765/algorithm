package Beginner_Coder;

import java.util.Scanner;

public class 최대공약수와최소공배수_1658 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = Math.min(N, M); //두 자연수 중 작은 수
		
		int GCD = 0 , lCM = 0; //최대 공약수, 최소 공배수
		for (int i = 1; i <= min; i++) {
			if( N % i == 0 && M % i == 0) GCD = i;
		}
		lCM = (N * M) / GCD;
		
		System.out.println(GCD);
		System.out.println(lCM);
	}
}
