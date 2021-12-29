package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj18111_마인크래프트 {

	static int N, M, B, map[][];
	static int time, height;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		time = Integer.MAX_VALUE;
		height = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i <= 256; i++) {
			solve(i);
		}
		System.out.println(time + " " + height);
	}

	private static void solve(int num) {
		int cnt = 0;
		int inventory = B;
		int small = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != num) {
					int dif = Math.abs(map[i][j]-num);
					if (map[i][j] < num) {
						small += dif;
					} else {
						cnt += dif*2;
						inventory+= dif;
					}
				}
			}
		}
		if(inventory < small)
			return;
		cnt += small;
		if(cnt <= time) {
			if(cnt < time) {
				time = cnt;
				height = num;
			}else {
				height = Math.max(height, num);
			}
		}
	}
}
