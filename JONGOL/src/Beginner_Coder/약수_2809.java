package Beginner_Coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 약수_2809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		
	
		int arr [] = new int [10000]; 
		int cnt = 0;
		//약수 구하기. N의 범위가 ~21억개이므로 범위 줄이기
		int sq = (int) Math.sqrt(N);
		//System.out.println(max);
		for (int i = 1; i <= sq; i++) {
			if(N % i == 0) { // i가 약수이면 
					arr[cnt++] = i; //i담고
					if(i != N/i ) {
						arr[cnt++] = N/i;
					}
				
			}
		}
		
		Arrays.sort(arr);
		
		for (int i : arr) {
			if(i != 0) System.out.print(i + " ");
		}
		
		
		
	}

}
