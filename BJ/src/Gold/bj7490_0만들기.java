package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj7490_0만들기 {

	static int N;
	static List<String> ans;
	static String op[] = {"+", "-", " "};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			ans = new ArrayList<>();
			dfs(1, "1");
			Collections.sort(ans);
			for(String s : ans) {
				System.out.println(s);
			}
			System.out.println();
			
		}
	}
	
	
	private static void dfs(int num, String s) {
		if(num == N) {
			String express = s.replaceAll(" ", "");
			if(cal(express))
				ans.add(s);
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			dfs(num+1, s+op[i]+Integer.toString(num+1));
		}
	}


	private static boolean cal(String express) {
		StringTokenizer st = new StringTokenizer(express, "-|+", true);
		int sum = Integer.parseInt(st.nextToken());
		while(st.hasMoreElements()) {
			String s = st.nextToken();
			if(s.equals("+")) {
				sum += Integer.parseInt(st.nextToken());
			}else {
				sum -= Integer.parseInt(st.nextToken());
			}
		}
		
		if(sum == 0)
			return true;
		return false;
	}
}
