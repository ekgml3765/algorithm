package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj20437_문자열게임2 {

	static int ans1, ans2, K;
	static String s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			s = in.readLine();
			K = Integer.parseInt(in.readLine());
			if(K == 1) {
				System.out.println("1 1");
				continue;
			}
			slideWindow();
		}	
	}

	private static void slideWindow() {
		int len = s.length();
		ans1 = Integer.MAX_VALUE;
		ans2 = Integer.MIN_VALUE;
		int alph[] = new int [26];
		
		//s의 각 알파벳 문자별 갯수 카운팅
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			alph[c-'a']++;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(alph[c - 'a'] < K) //알파엣이 K개 이상일때만 살펴본다.
				continue;
			int cnt = 1;
			for (int j = i+1; j < s.length(); j++) {
				if(s.charAt(j) == c)
					cnt++;
				if(cnt == K) {//알파벳을 정확히 K개 포함
					ans1 = Math.min(ans1, j-i+1); //그 길이가 가장 짧다면 갱신
					ans2 = Math.max(ans2, j-i+1); //그 길이가 가장 길다면 갱신
					break;
				}
			}
		}
		
		if(ans1 == Integer.MAX_VALUE || ans2 == Integer.MIN_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans1 + " " + ans2);
	}
}
