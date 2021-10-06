package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[101][101];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int sc = Integer.parseInt(st.nextToken());
			int sr = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			for (int r = sr; r < er; r++) {
				for (int c = sc; c < ec; c++) {
					arr[r][c] = 1;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(arr[i][j] == 1)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
