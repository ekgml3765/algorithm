package Silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class bj12919_A와B2 {

	static String T;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine();
		String T = in.readLine();
		boolean flag = dfs(T, S);
		System.out.println((flag==true)? 1 : 0);
	}
	
	private static boolean dfs(String T, String S) {
		if(S.length() == T.length()) {
			if(S.equals(T))
				return true;
			return false;
		}
		if(T.charAt(0) == 'A' && T.charAt(T.length()-1) == 'A') {
			if(dfs(T.substring(0, T.length()-1), S))
				return true;
		}
		else if(T.charAt(0) == 'A' && T.charAt(T.length()-1) == 'B') {
			return false;
		}
		else if(T.charAt(0) == 'B' && T.charAt(T.length()-1) == 'A') {
			if(dfs(T.substring(0, T.length()-1), S))
				return true;
			String s = new StringBuffer(T.substring(1, T.length())).reverse().toString();
			if(dfs( s, S))
				return true;
		}
		else if(T.charAt(0) == 'B' && T.charAt(T.length()-1) == 'B') {
			String s = new StringBuffer(T.substring(1, T.length())).reverse().toString();
			if(dfs( s, S))
				return true;
		}
		return false;
	}
}
