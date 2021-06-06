package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약수와배수_1071 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int arr[] = new int [n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(in.readLine());
		
		int factor = 0, multiple = 0; //약수, 배수
		
		for (int i = 0; i < n; i++) {
			if( m % arr[i] == 0) factor += arr[i]; //약수의 합
			if( arr[i] % m == 0) multiple += arr[i]; //배수의 합
		}
		
		System.out.println(factor);
		System.out.println(multiple);
	}
}
