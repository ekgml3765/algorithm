package Level3;

import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int table_size = n;
        for(int i = 0; i < cmd.length; i++){
            char c = cmd[i].charAt(0);
            if(c == 'U'){
                k-=Integer.parseInt(cmd[i].substring(2));
            }else if(c == 'D'){
                k+=Integer.parseInt(cmd[i].substring(2));
            }else if(c == 'C'){
                stack.add(k);
                table_size--;
                if(k == table_size)
                    k--;
            }else{
                if(stack.pop() <= k)
                    k++;
                table_size++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < table_size; i++)
            sb.append("O");
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            sb.insert(idx, "X");            
        }
        String ans = sb.toString();
        return ans;
        
    }
}