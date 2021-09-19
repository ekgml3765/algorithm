package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1780_종이의개수 {

	static int N, map[][], zero = 0, one = 0, minus = 0;
	public static void main(String[] args) throws IOException {
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
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
	private static void solve(int r, int c, int size) {
		if(check(r, c, size)) {
			int num = map[r][c];
			if(num == 0)
				zero++;
			if(num == 1)
				one ++;
			if(num == -1)
				minus ++;
			return;
		}
		
		int newSize = size / 3;
		for (int i = r; i < r+size; i+= newSize) {
			for (int j = c; j < c+size; j += newSize) {
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
