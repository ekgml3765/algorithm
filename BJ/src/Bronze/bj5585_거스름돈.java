package Bronze;

import java.util.Scanner;

public class bj5585_거스름돈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 1000 - sc.nextInt();
		int ans = 0;
		int arr[] = { 500, 100, 50, 10, 5, 1 };
		for (int i = 0; i < arr.length; i++) {
			int quo = N / arr[i];
			ans += quo;
			N %= arr[i];
			if(N  == 0)
				break;	
		}
		System.out.println(ans);
	}
}
