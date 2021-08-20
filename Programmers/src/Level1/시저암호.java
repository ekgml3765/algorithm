package Level1;

public class 시저암호 {

	   public String solution(String s, int n) {
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < s.length(); i++){
	            char c = s.charAt(i);
	            char word = (char)(c+n);
	            if(c == ' '){
	                sb.append(c);
	                continue;
	            }
	            if(Character.isLowerCase(c)){
					word = (word >'z')? (char)(word-'z'+'a'-1) : word;
	            }else{
					word = (word >'Z')? (char)(word-'Z'+'A'-1) : word;
	            }
	             sb.append(word);
	        }
	        return sb.toString();
	    }
}
