package Level1;

import java.util.Arrays;

public class 위클리챌린지_4주차 {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max = 0;
        Arrays.sort(table);
        for(int i = 0 ; i < table.length; i ++){
            String arr[] = table[i].split(" ");
            int sum = 0;
            for(int j = 0; j < languages.length; j ++){
                for(int k = 1; k < arr.length; k++){
                    if(arr[k].equals(languages[j])){
                        sum += (preference[j]*(arr.length-k));
                        break;
                    }
                }
            }
            System.out.println(arr[0] + " " + sum);
            if(max < sum){
                max = sum;
                answer = arr[0];
            }
        }
        return answer;
    }
}
