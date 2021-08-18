package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj4889_안정적인문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true) {
			String s = in.readLine();
			if(s.contains("-"))
				break;
			char arr[] = s.toCharArray();
			int cnt = 0;
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < arr.length; i++) {
				char c = arr[i];
				if(c == '{') {
					stack.add(c);
				}else {
					if(stack.isEmpty()) {
						cnt++;
						stack.add('{');
						continue;
					}else {
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty()) {
				cnt += stack.size()/2;
			}
			System.out.println(tc+". "+cnt);
			tc++;
		}
		
	}
}
