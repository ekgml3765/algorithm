package Beginner_Coder;

import java.util.ArrayList;
import java.util.Scanner;

public class 소수의개수_2813 {

	static int prime[];
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		prime = new int [2000005]; //1부터 2,000,000까지 소수인지 아닌지 판별할 배열
		
		int cnt = 0;
		eratos(N);
		//M이상 N이하 소수 찾기.
		for (int i = M; i <= N; i++) {
			if(prime[i] == 0) { // 0이면 다 소수
				cnt++;
			}
		}


		System.out.println(cnt);
		
	}

	//num 까지 소수는 0, 소수가 아니면1
	private static void eratos(int num) {
		prime[0] = prime[1] = 1; // 0과, 1은 소수가 아님
		
		// 범위는 제곱근으로 소수판별
		for (int i = 2; i <= num / i; i++) {
			if(prime[i] == 0) { //기본 int배열은 0으로 초기화되있으므로
				//해당 i가 소수인지 아닌지 판별.
				for (int j = i*i; j <= num; j += i) {
					prime[j] = 1; // j배수는 소수가 아니므로 1
				}
			}
		}
	}
}
