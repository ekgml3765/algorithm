package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class bj2504_괄호의값 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		char arr[] = in.readLine().toCharArray();
		int ans = 0;
		int tmp = 1;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if(c == '(' || c == '[') { // (, [ 일 경우
				stack.add(c);
				tmp *= (c=='(')? 2: 3;
			}
			else { // ), ]일 경우
				if(stack.isEmpty()) {
					ans = 0;
					break;
				}else {
					char cc = stack.pop();
					if(c == ')') {
						if(cc != '(') {
							ans = 0;
							break;
						}else {
							if(arr[i-1] == '(')
								ans += tmp;
							tmp /= 2;
						}	
					}else {
						if(cc != '[') {
							ans = 0;
							break;
						}else {
							if(arr[i-1] == '[')
								ans += tmp;
							tmp /= 3;
						}
					}
				}			
			}
			//System.out.println(tmp + " ans는" + ans);
		}//end for
		if(!stack.isEmpty())
			ans = 0;
		System.out.println(ans);
	}
}
