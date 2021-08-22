package Level1;

public class 비밀지도_1차 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String [n];
        for(int i = 0 ; i < arr1.length; i++){
            String s = Integer.toString(arr1[i]|arr2[i], 2);
            s = s.replace("0", " ");
            s = s.replace("1", "#");
            if(s.length() != n){
                String add = "";
                for(int j = 0; j < n-s.length(); j++)
                    add += " ";
                s = add+s;
            }      
            answer[i] = s;
        }
        return answer;
    }
}
