package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1759_암호만들기 {

	static int L, C;
	static char arr[];
	static char sel[];
	static boolean check[];
	static String s = "aeiou";
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		sel = new char[L];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
	    check = new boolean[C];
		dfs(0, 0, 0);
	}

	private static void dfs(int idx, int mo, int za) {
		if (idx == L) {
			if(mo >= 1 && za >=2) {
				for (int i = 0; i < sel.length; i++) {
					System.out.print(sel[i]);
				}
				System.out.println();
			}
			return;
		}

		for (int i = 0; i < C; i++) {
			if(idx > 0 && sel[idx-1] > arr[i])
					continue;
			if (!check[i]) {
				check[i] = true;
				sel[idx] = arr[i];
			    if(s.contains(Character.toString(arr[i])))
			    	dfs(idx + 1, mo+1, za);
			    else
			    	dfs(idx + 1, mo, za+1);
				check[i] = false;
			}
		}
	}
}
