package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int map[][] = new int[H][W];
		st = new StringTokenizer(in.readLine());
		for (int j = 0; j < W; j++) {
			int num = Integer.parseInt(st.nextToken());
			for (int i = H-1; i >= H - num; i--) {
				map[i][j] = 1;
			}
		}
		int ans = 0;
		for (int i = H-1; i >= 0; i--) {
			int cnt = 0;
			boolean block = false;
			boolean can = false;
			for (int j = 0; j < W; j++) {
				if(!block && map[i][j] == 1) {
					block = true;
				}
				if(block && map[i][j] == 0) {
					cnt++;
					can = true;
				}
				if(block && can && map[i][j] == 1) {
					ans += cnt;
					cnt = 0;
					can = false;
				}
			}
		}
		System.out.println(ans);
	}
}
