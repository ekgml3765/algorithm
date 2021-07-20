package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); //시험장 수
		long people[] = new long[N];//응시자수
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < people.length; i++) {
			people[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(in.readLine(), " ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long ans = 0;
		for (int i = 0; i < people.length; i++) {
			long person = people[i]-B;
			ans++;
			if(person > 0) {
				if(person % C == 0) {
					ans += person / C;
				}else {
					ans += person / C;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
