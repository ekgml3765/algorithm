package Beginner_Coder;

import java.util.ArrayList;
import java.util.Scanner;

public class 소수_1740 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		//소수를 담을 List
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int sum = 0;
		//M이상 N이하 소수 찾기.
		for (int i = M; i <= N; i++) {
			if(prime(i)) {
				sum += i;
				arr.add(i);
			}
		}
		
		//소수가 없다면
		if(arr.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(sum);
		System.out.println(arr.get(0));
		
	}

	//소수인지 아닌지 확인하는 메서드
	private static boolean prime(int num) {
		if(num < 2) {
			return false; //입력이 1이 들어오면 1은 소수가 아니므로
		}
		for (int i = 2; i <= num / i; i++) {
			if(num % i == 0) {
				return false; //소수가 아니면 false
			}
		}
		return true; //소수이면 true
	}
}
