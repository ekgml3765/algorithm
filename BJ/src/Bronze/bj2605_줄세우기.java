package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2605_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(i-Integer.parseInt(st.nextToken()), i+1);
		}
		for (int i = 0; i < N; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
