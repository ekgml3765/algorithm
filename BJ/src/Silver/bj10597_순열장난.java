package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10597_순열장난 {
	static String s;
	static boolean visit[];
	static int len;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		s = in.readLine();
		len = s.length();
		visit = new boolean[51];
		dfs(0, 0, "");
	}
	private static void dfs(int idx, int N, String ans) {
		if(idx == len ) {
			for (int i = 1; i <= N; i++) {
				if(!visit[i])
					return;
			}
			System.out.println(ans.trim());
			System.exit(0);
			return;
		}
		
		String tmp = s.substring(idx, idx+1);
		int num = Integer.parseInt(tmp);
		if(!visit[num]) {
			visit[num] = true;
			dfs(idx+1, (num > N)? num : N, ans+" "+tmp);
			visit[num] = false;
		}
		if(idx < len-1) {
			tmp = s.substring(idx, idx+2);
			num = Integer.parseInt(tmp);
			if(num < 51 &&!visit[num]) {
				visit[num] = true;
				dfs(idx+2, (num > N)? num : N, ans+" "+tmp);
				visit[num] = false;
			}
		}	
	}
}
