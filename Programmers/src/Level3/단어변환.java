package Level3;

public class 단어변환 {
    public static String arr[];
    public static boolean check[];
    public static int ans = 99999;
    //글자 변환 가능한지 체크
    public static boolean checking(String first, String second){

        int cnt = 0;
        for(int i = 0 ; i < second.length(); i++){
            if(first.charAt(i) == second.charAt(i))
                cnt++;
        }
        if(cnt == second.length() -1){
            return true;
        }
        return false;
    }

    //순열
    public static void perm(String begin, String target, int cnt){
        if(begin.equals(target)){
            ans = Math.min(ans, cnt);
            return;
        }    
        for(int i = 0 ; i < arr.length; i++){
            if(!check[i] && checking(begin, arr[i])){
                check[i] = true;
                perm(arr[i], target, cnt+1);
                check[i] = false;
            }
        }
    } 
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        //변환 할 수 없는 경우 0리턴
        boolean flag = true;
        for(int i = 0 ; i < words.length; i++){
            if(words[i].equals(target)){
                flag = false;
            }
        }
        if(flag)
            return 0;

        //배열 복사
        arr = new String [words.length]; 
        for(int i = 0 ; i < words.length; i++){
                arr[i] = words[i];
        }

        //words에서 뽑는 순열
        check = new boolean[words.length];
        perm(begin, target, 0);
        answer = ans;
        return answer;
    }
}
