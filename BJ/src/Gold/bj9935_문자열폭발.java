package Gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		String pop = in.readLine();
		int size = pop.length();
		StringBuilder sb = new StringBuilder();		
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if(sb.length() >= pop.length()) {
				//검사
				boolean flag = true;
				for (int k = 1, j = size -1; j >= 0; j--, k++) {
					 char c1 = sb.charAt(sb.length()-k);
					 char c2 = pop.charAt(j);
					 if(c1 != c2) {
						 flag = false;
						 break;
					 }
				}
				if(flag) {
					sb.delete(sb.length()-size, sb.length());
				}
			}
		}
		String ans = sb.toString();
		System.out.println((ans.equals(""))? "FRULA" : ans);
	}
}