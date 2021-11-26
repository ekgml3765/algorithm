package Level2;

import java.util.HashMap;

public class 단체사진찍기 {

	   static String[] Data;
	    static int ans;
	    static int sel[] = new int[8];
	    static boolean visit[] = new boolean[8];
	    static HashMap<Character, Integer> map = new HashMap<>();
	    public int solution(int n, String[] data) {
	        Data = data;
	        ans = 0;
	        map.put('A', 0);
	        map.put('C', 1);
	        map.put('F', 2);
	        map.put('J', 3);
	        map.put('M', 4);
	        map.put('N', 5);
	        map.put('R', 6);
	        map.put('T', 7);
	        perm(0);
	        return ans;
	    }
	    public static void perm(int idx){
	        if(idx == 8){
	            if(check())
	                ans++;
	            return;
	        }
	        for(int i = 0 ; i < 8 ; i++){
	            if(!visit[i]){
	                visit[i] = true;
	                sel[idx] = i;
	                perm(idx+1);
	                visit[i] = false;
	            }
	        }
	    }
	    public static boolean check(){
	        for(String s : Data){
	            int a = sel[map.get(s.charAt(0))];
	            int b = sel[map.get(s.charAt(2))];
	            char op = s.charAt(3);
	            int size = s.charAt(4)-'0';
	            // 0 1 2 3 4 5 6 7
	            if(op == '='){
	                if(Math.abs(b-a)-1 != size)
	                    return false;
	            }
	            else if(op == '>'){
	                 if(Math.abs(b-a)-1 <= size)
	                    return false;
	            }
	            else{
	                if(Math.abs(b-a)-1 >= size)
	                    return false;
	            }
	        }
	        return true;
	    }
}
