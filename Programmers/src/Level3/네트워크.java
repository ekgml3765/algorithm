package Level3;

import java.util.*;

public class 네트워크 {
    public static boolean check[][];
    static int N;
    public static void dfs(int r, int[][] computers){
        //모든 열에 대해서
        for(int i = 0; i < N; i++ ){
            if(computers[r][i] != 0 && !check[r][i]){
                check[r][i] = true; //방문체크
                dfs(i, computers);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        check = new boolean [n][n];
        for(int i = 0; i < N; i++ ){
           for(int j = 0 ; j < N; j++){
               if(!check[i][j] && computers[i][j] != 0){
                    answer++;
                    check[i][j] = true;
                    dfs(i, computers);
               }
           }
        }
        return answer;
    }
}