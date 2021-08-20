package Level1;

public class 문자열내p와y의개수 {

    boolean solution(String s) {
        s = s.toLowerCase();
        int p = 0;
        int y = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'p')
                p++;
            if(c == 'y')
                y++;
        }
        return (p==y)? true : false;
    }
}
