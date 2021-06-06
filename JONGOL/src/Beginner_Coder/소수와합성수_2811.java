package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수와합성수_2811 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		// 입력
		for (int i = 0; i < 5; i++) {
			int N = Integer.parseInt(st.nextToken());
			
			if (N == 1) { // 소수도 합성수도 아니면
				System.out.println("number one");
				continue;
			}

			// 소수인지 아닌지 판단
			boolean flag = true;
			for (int j = 2; j <= N / j; j++) {
				// 나누어 떨어진다면 합성수
				if (N % j == 0) {
					System.out.println("composite number");
					flag = false; //합성수라면 flag = false;
					break;
				}
			}
			// flag가 true라면 소수
			if(flag) System.out.println("prime number");

		}

	}
}
