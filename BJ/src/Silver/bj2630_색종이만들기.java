package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2630_색종이만들기 {
	static int N, map[][], white = 0, blue = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	private static void solve(int r, int c, int size) {
		if(check(r, c, size)) {
			if(map[r][c] == 0)
				white++;
			else
				blue++;
			return;
		}
		int newSize = size / 2;
		for (int i = r; i < r + size; i+=newSize) {
			for (int j = c; j < c + size; j+=newSize) {
				solve(i, j, newSize);
			}
		}
	}
	
	private static boolean check(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if(map[r][c] != map[i][j])
					return false;
			}
		}
		return true;
	}
}
