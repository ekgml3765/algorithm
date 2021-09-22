package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1138_한줄로서기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String arr[] = in.readLine().split(" ");
		int ans[] = new int[arr.length];
		for (int i = arr.length-1, j = 0; i >= 0; i--, j++) {
			int cnt = Integer.parseInt(arr[i]);
			if(cnt == j) {
				ans[j] = i+1;
			}else {
				for (int k = j; k > cnt; k--) {
					ans[k] = ans[k-1];
				}
				ans[cnt] = i+1;
			}
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
