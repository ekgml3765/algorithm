package Beginner_Coder;

import java.util.ArrayList;
import java.util.Scanner;

public class 소수구하기_1901 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 처리해야할 갯수

		// N개 만큼 입력 받음
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();

			boolean flag = false;
			ArrayList<Integer> arr = new ArrayList<Integer>();
			
			//뺴거나 더하지 않고 num자체가 소수일 수도 있음.
			if (prime(num)) {
				System.out.println(num);
				continue;
			}
			
			for (int j = 1; j <= 1000000 - j; j++) {

				// j씩 빼보기
				if (1 < (num - j) && prime(num - j)) {
					flag = true;
					arr.add(num - j);
				}
				// j씩 더해보기
				if (prime(num + j)) {
					flag = true;
					arr.add(num + j);
				}

				if (flag) {
					for (int number : arr) {
						System.out.print(number + " ");
					}
					System.out.println();
					break;
				}
			}
		}

	}

	// 소수인지 아닌지 확인하는 메서드
	private static boolean prime(int num) {

		for (int i = 2; i <= num / i; i++) {
			if (num % i == 0) {
				return false; // 소수가 아니면 false
			}
		}
		return true; // 소수이면 true
	}
}
