package Level1;

public class 행렬의곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int answer[][] = new int[arr1.length][arr2[0].length];
         for(int i = 0; i < arr1.length; i ++){
             for(int j = 0; j < arr2[0].length; j++){
                int copy[] = arr1[i];
                 int sum = 0;
                 for(int k = 0; k < copy.length; k++){
                     sum += copy[k]*arr2[k][j];
                 }
                 answer[i][j] = sum;
             }
         }   
         return answer;
     }
}
