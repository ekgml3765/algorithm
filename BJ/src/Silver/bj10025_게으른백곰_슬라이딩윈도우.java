package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10025_게으른백곰_슬라이딩윈도우 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[1000001];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x] = g;
		}
		int max = 0;
		int start = 0;
		int window = 2*K+1;;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if(i >= window) {
				sum -= arr[i-window];
			}
			sum += arr[i];
			max = Math.max(sum, max);
		}
		System.out.println(max);	
	}
}
