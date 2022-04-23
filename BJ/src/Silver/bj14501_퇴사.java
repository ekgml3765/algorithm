package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14501_퇴사 {

	static int N, map[][], ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}

		powerSet(0, 0);
		System.out.println(ans);
	}

	private static void powerSet(int idx, int sum) {
		if(idx >= N) {
			ans = Math.max(ans, sum);
			return;
		}
		
		if(map[idx][0] + idx <= N)
			powerSet(idx+map[idx][0], sum+map[idx][1]);
		powerSet(idx+1, sum);

	}

}
