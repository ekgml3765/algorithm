package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1992_쿼드트리 {
	static int N;
	static String map[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new String[N][N];
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			map[i] = s.split("");
		}
		quadTree(0, 0, N);
		System.out.println(sb.toString());
	}
	
	private static void quadTree(int r, int c, int size) {
		
		if(check(r, c, size)) {
			sb.append(map[r][c]);
			return;
		}
		int newSize = size/2;
		sb.append("(");
		quadTree(r, c, newSize);//왼쪽위
		quadTree(r, c+newSize, newSize);//오른쪽 위
		quadTree(r+newSize, c, newSize);//왼쪽 아래
		quadTree(r+newSize, c+newSize, newSize);//오른쪽 아래
		sb.append(")");
	}

	private static boolean check(int r, int c, int size) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(!map[i][j].equals(map[r][c]))
					return false;
			}
		}
		return true;
	}
}
