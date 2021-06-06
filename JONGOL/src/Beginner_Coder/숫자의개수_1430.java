package Beginner_Coder;

import java.util.Scanner;

public class 숫자의개수_1430 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		String ans = Integer.toString((A * B * C));
		int num [] = new int [10];
		for (int i = 0; i < ans.length(); i++) {
			num[ans.charAt(i)-'0'] ++;
		}
		
		for (int i : num) {
			System.out.println(i);
		}
		
		
	}
}
