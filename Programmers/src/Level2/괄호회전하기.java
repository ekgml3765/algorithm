package Level2;

import java.util.Stack;

public class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            String a = s.substring(0,1);
            s = s.substring(1, s.length());
            s += a;
            if(check(s))
                answer++;
        }
        return answer;
    }
    public static boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{' || c == '['|| c == '(' ){
                stack.add(c);
            }else{
                if(stack.isEmpty())
                    return false;
                else{
                    char pop = stack.pop();
                    if(c == ')' && pop =='(')
                        continue;
                    if(c == '}' && pop =='{')
                        continue;
                    if(c == ']' && pop =='[')
                        continue;
                    return false;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
