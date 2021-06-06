package Beginner_Coder;

import java.util.Scanner;

public class 이진수_2814 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String s = sc.next();
		char ch[] = s.toCharArray();
		
		int ans = 0;
		for (int i = 0; i < ch.length; i++) {
			int n = (int) Math.pow(2, (ch.length - 1 - i)) * (ch[i] - '0');
		
			ans += n;
		}
		
		System.out.println(ans);
	}
}
