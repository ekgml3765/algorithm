package Beginner_Coder;

import java.util.Scanner;

public class 최대공약수_최소공배수_1002 {


	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt(); //입력
		}
		
		int GCD = arr[0], lCM = arr[0]; //최대 공약수, 최소 공배수
		//두 수 씩 비교하기 
		for(int i = 1; i < n; i++ ) {
			GCD = get_GCD(GCD, arr[i]); 
			lCM = (lCM * arr[i]) / get_GCD(lCM, arr[i]);
		}
		System.out.println(GCD + " " + lCM);
	}

	private static int get_GCD(int a, int b) {
		int GCD = 0;
		int min = Math.min(a, b);
		for (int i = 1; i <= min ; i++) {
			if(a % i == 0 && b % i == 0) {
				GCD = i;
			}
		}
		return GCD;
		
	}
}
