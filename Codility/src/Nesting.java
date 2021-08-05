
import java.util.*;

class Nesting {
    public int solution(String S) {
       int ans = 0;
       Stack<Character> stack = new Stack<>();
       char c[] = S.toCharArray();
       for(int i = 0; i < c.length; i++){
           if(c[i] == '(')
            stack.add(c[i]);
           else{
               if(!stack.isEmpty()){
                   stack.pop();
               }else{
                   return 0;
               }
           }
       }
       if(stack.isEmpty())
            return 1;
       return 0;
    }
}