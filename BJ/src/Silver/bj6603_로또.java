package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj6603_로또 {

	static int arr[];
	static int sel[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int size = Integer.parseInt(st.nextToken());
			if(size == 0)
				break;
			arr = new int[size];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sel = new int[6];
			comb(0,0);
			System.out.println();
		}
	}

	private static void comb(int idx, int s_idx) {
		if (s_idx == 6) {
			for(int i = 0 ; i < sel.length; i++) {
				System.out.print(sel[i]+ " ");
			}
			System.out.println();
			return;
		}

		if (idx == arr.length) {
			return;
		}	
		sel[s_idx] = arr[idx];
		comb(idx+1, s_idx+1);
		comb(idx+1, s_idx);
	}
}
