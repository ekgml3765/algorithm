package Level2;

import java.util.Arrays;
import java.util.StringTokenizer;

public class JadenCase문자열만들기 {
    public static String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ",true);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
        	String ss = st.nextToken();
        	if(ss.equals(" "))
        		sb.append(ss);
        	else {
        		sb.append(ss.substring(0,1).toUpperCase()+ss.substring(1, ss.length()).toLowerCase());
        	}
        }
        return sb.toString();
    }
}
