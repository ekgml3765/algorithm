package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19637_IF문좀대신써줘 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		String power[] = new String[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			power[i] = st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(in.readLine());
			int start = 0;
			int end = N-1;
			int ans = 0;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(num <= arr[mid]) {
					ans = mid;
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
			sb.append(power[ans] + "\n");
		}
		System.out.println(sb);
	}
}
