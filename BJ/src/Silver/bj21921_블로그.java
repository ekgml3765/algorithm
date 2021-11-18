package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj21921_블로그 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		long max = 0;
		int day = 0;
		int arr[] = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (long)arr[i];
			if(i >= X) {
				sum -= arr[i-X];
			}
			if(sum >= max) {
				if(sum == max) {
					day++;
				}else {
					max = sum;
					day = 1;
				}
			}
		}
		if(max == 0)
			System.out.println("SAD");
		else
			System.out.println(max + "\n" + day);
	}
}
