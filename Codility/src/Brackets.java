
import java.util.*;

class Brackets {
    public int solution(String S) {
        //(), {}, []
        int ans = 0;
        char c[] = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < c.length; i++){
            if(c[i] == '(' || c[i] == '{' || c[i] == '['){

                stack.add(c[i]);
            }
            else{
                if(!stack.isEmpty()){
                    char ch = stack.peek();
                    if(c[i] == ')' && ch =='('){
                        stack.pop();
                    }
                     if(c[i] == '}'&& ch =='{'){
                        stack.pop();
                    }
                     if(c[i] == ']'&& ch =='['){
                        stack.pop();
                    }
                }else
                    return 0;
            }
        }
        if(stack.isEmpty())
            return 1;
        return ans;
    }
}