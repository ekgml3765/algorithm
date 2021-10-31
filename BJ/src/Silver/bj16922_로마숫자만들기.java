package Silver;

import java.util.HashSet;
import java.util.Scanner;

public class bj16922_로마숫자만들기 {
	static int arr[] = {1, 5, 10, 50};
	static int N;
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		perm(0, 0, 0);
		System.out.println(set.size());
	}
	private static void perm(int idx, int start, int sum) {
		if(idx == N) {
			set.add(sum);
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			perm(idx+1, i, sum + arr[i]);
		}
		
	}
}
