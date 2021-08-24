package Level2;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.add(c);
            }else{
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
