package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			Stack stack = new Stack<Character>();
			int left = 0;
			int right = 0;
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '(') {
					stack.add('(');
					left++;
				}
				else {// )일 경우
					right++;
					if(!stack.isEmpty()) {
						stack.pop();
					}		
				}
			}
			if(stack.isEmpty() && left == right)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}
}
