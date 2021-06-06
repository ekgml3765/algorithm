package Beginner_Coder;

import java.util.Scanner;

public class 곱셈_1692 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(); //(1)
		String m = sc.next(); //(2)
		
		int num[] = new int[3];
		for (int i = 0; i < 3; i++) {
			num[i] = m.charAt(i) - '0'; //한자리씩 띄어서 배열에 담은
		}
		int arr[] = new int [4]; //답을 담을 배열
		for (int i = 0; i < 3 ; i++) {
			arr[i] = n * num[i];
		}
		arr[3] = n * Integer.parseInt(m); 	
		for (int i = 2; i >= 0; i--) {
			System.out.println(arr[i]);
		}
		System.out.println(arr[3]);
		
	}
}
