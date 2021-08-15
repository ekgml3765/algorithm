package Bronze;

import java.util.Arrays;
import java.util.Scanner;

public class bj2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		int ans = 0;
		int bongi = 0;
		while(true) {
			if(N%5 == 0) {
				ans = (N/5) + bongi;
				break;
			}
			N -= 3;
			bongi++;
			if(N < 0) {
				ans = -1;
				break;
			}
		}
		System.out.println(ans);
	}
}
