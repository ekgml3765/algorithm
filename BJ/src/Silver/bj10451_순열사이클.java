package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10451_순열사이클 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int size = Integer.parseInt(in.readLine());
			int arr[] = new int[size+1];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 1; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			boolean visit[] = new boolean[size+1];
			for (int i = 1; i < arr.length; i++) {
				if(!visit[i]) {
					visit[i] = true;
					int go = arr[i];
					while(true) {
						if(visit[go]) {
							ans++;
							break;
						}
						visit[go] = true;
						go = arr[go];
					}
				}
			}
			System.out.println(ans);
		}
	}
}
