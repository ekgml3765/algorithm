package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13458_시험감독_2회독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		long ans = 0;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if(num <= B) {
				ans+= 1;
			}else {
				ans++; //총감독
				num-=B;
				ans += (num%C == 0)? num/C : (num/C)+1;
			}
		}
		System.out.println(ans);
	}
}
