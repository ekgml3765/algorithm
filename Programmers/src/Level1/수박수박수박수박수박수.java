package Level1;

public class 수박수박수박수박수박수 {
    public String solution(int n) {
        char[] arr = {'수','박'};
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i ++){
            sb.append(arr[i%2]);
        }
        return sb.toString();
    }
}
