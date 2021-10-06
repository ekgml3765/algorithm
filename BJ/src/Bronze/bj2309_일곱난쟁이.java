package Bronze;

import java.util.Arrays;
import java.util.Scanner;

public class bj2309_일곱난쟁이 {

	static int arr[], sel[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		sel = new int[7];
		comb(0, 0);
	}
	private static void comb(int idx, int s_idx) {
		if(s_idx == 7) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if(sum == 100) {
				Arrays.sort(sel);
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}
				System.exit(0);
			}
			return;
		}
		if(idx == 9)
			return;
		sel[s_idx] = arr[idx];
		comb(idx+1, s_idx+1);
		comb(idx+1, s_idx);	
	}
}
