package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1062_가르침 {

	static String word[];
	static int N, K;
	static boolean visit[];
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(K < 5) {
			System.out.println(0);
			return;
		}
		if(K == 26) {
			System.out.println(N);
			return;
		}
		K -= 5;
		word = new String[N];
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			word[i] = s.substring(4, s.length()-4);
		}
		visit = new boolean[26];
		visit['a'-'a'] = true;
		visit['c'-'a'] = true;
		visit['n'-'a'] = true;
		visit['t'-'a'] = true;
		visit['i'-'a'] = true;
		go(0, 0);
		System.out.println(ans);
	}
	private static void go(int alpha, int idx) {
		if(idx == K) {
			int cnt = 0;
			out: for (int i = 0; i < N; i++) {
				for (int j = 0; j < word[i].length(); j++) {
					if(!visit[word[i].charAt(j)-'a'])
						continue out;
				}
				cnt++;
			}
			ans = Math.max(ans, cnt);
			return;
		}
		for (int i = alpha; i < 26; i++) {
			if(!visit[i]) {
				visit[i] = true;
				go(i, idx+1);
				visit[i] = false;
			}
		}
	}
}
