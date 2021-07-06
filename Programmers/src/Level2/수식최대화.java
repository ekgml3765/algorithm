package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 수식최대화 {

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		solution(expression);
	}

	static String operation;
	static List<String> ex;
	static String[] arr;
	static String[] sel;
	static boolean[] check;
	static int cnt = 0;
	static long ans = 0;
	private static void perm(int idx) {
		if(idx == sel.length) {
			String[] newEx = ex.toArray(new String[ex.size()]);	
				for (int i = 0; i < sel.length; i++) {
					Stack<String> stack = new Stack<String>();
					for (int j = 0; j < newEx.length; j++) {
						if(newEx[j].equals(sel[i])) {
							long sum = 0;
							long num1 = Long.parseLong(stack.pop());
							long num2 = Long.parseLong(newEx[j+1]);
							if(sel[i].equals("-")) {
								sum = num1 - num2;
							}
							if (sel[i].equals("*")){
								sum = num1 * num2;
							}
							if(sel[i].equals("+")) {
								sum = num1 + num2;
							}						
							stack.push(Long.toString(sum));
							j = j+1;
						}else {
							stack.push(newEx[j]);
						}
					}
					//식 새로 만들기
					newEx = stack.toArray(new String[stack.size()]);
				}//end for
				ans = Math.max(ans, Math.abs(Long.parseLong(newEx[0])));
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				sel[idx] = arr[i];
				perm(idx+1);
				check[i] = false;
			}
		}
		
	}
	public static long solution(String expression) {
		long answer = 0;
		//문자열 끊기
		ex = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(expression, "*|-|+", true);
		operation = "";
		while(st.hasMoreElements()) {
			String s = st.nextToken();
			ex.add(s);
			if( "*-+".contains(s) && operation.length() == 0)
				operation += s;
			else {
				if("*-+".contains(s) && !operation.contains(s))
					operation+= s;
			}
		}
		arr = operation.split("");
		sel = new String[arr.length];
		check = new boolean[arr.length];
		perm(0);
		answer = ans;
		return answer;
	}

}
