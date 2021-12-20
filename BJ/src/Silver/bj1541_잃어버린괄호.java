package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), "-");
		List<Integer> list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(s, "+");
			int sum = 0;
			while(st2.hasMoreTokens()) {
				sum += Integer.parseInt(st2.nextToken());
			}
			list.add(sum);
		}
		int ans = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			ans -= list.get(i);
		}
		System.out.println(ans);
	}
}
