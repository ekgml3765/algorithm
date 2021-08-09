package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class bj1038_감소하는수 {

	static int number[], order;
	static boolean check[];
	static int sel[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		number = new int[10];
		check = new boolean[10];
		for (int i = 0; i < number.length; i++) {
			number[i] = i;
		}
		order = sc.nextInt();
		if(order < 10) {
			System.out.println(order);
			return;
		}
		boolean flag = false;
		for (int i = 2; i <= 10; i++) {
			check = new boolean[10];
			sel = new int[i];
			if(perm(0, i)) {
				flag = true;
				break;
			}
		}
		if(!flag)
			System.out.println(-1);
	}
	static int cnt = 9;
	private static boolean perm(int idx, int r) {
		if(idx == r) {
			cnt++;
			if(cnt == order) {
				for (int i = 0; i < sel.length; i++) {
					System.out.print(sel[i]);
				}
				return true;
			}
			return false;
		}
		for (int i = 0; i < number.length; i++) {
			if(!check[i]) {
				if(idx > 0 && sel[idx-1] < number[i])
					continue;
				check[i] = true;
				sel[idx] = number[i];
				if(perm(idx+1, r))
					return true;
				check[i] = false;
			}
		}
		return false;
	}
}
