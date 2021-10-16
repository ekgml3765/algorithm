package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14467_소가길을건너간이유 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[11];
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(arr[idx] == -1)
				arr[idx] = num;
			else {
				if(arr[idx] == num)
					continue;
				ans++;
				arr[idx] = num;
			}
		}
		System.out.println(ans);
		
	}
}
