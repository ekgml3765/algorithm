package Gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class bj12904_A와B {

	static String T;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer S = new StringBuffer(in.readLine());
		StringBuffer T = new StringBuffer(in.readLine());
		while(true) {
			if(S.length() == T.length()) {
				if(S.toString().equals(T.toString()))
					System.out.println(1);
				else
					System.out.println(0);
				break;
			}
			if(T.charAt(T.length()-1) == 'A') {
				T.deleteCharAt(T.length()-1);
			}else {
				T.deleteCharAt(T.length()-1);
				T.reverse();
			}
		}
	}
}
