package Beginner_Coder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 십진수를2816진수로_1534 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 10진수
		int B = sc.nextInt(); // 진법

		int quo = N; // 몫
		ArrayList<Integer> arr = new ArrayList<Integer>(); // 나머지를 담을 배열

		while (quo != 0) {
			arr.add(quo % B); // 나머지 담음
			quo = quo / B;

		}

		Collections.reverse(arr);
		
	
		
		//출력
		for (Integer i : arr) {
			//16진수일때 10 이상의 수 A, B, C, D, E, F처리
			if(B==16 &&  (10 <= i && i <= 15) ) {
				System.out.print((char)(i+55));
				continue;
			}
			System.out.print(i);
		}
	}
}
