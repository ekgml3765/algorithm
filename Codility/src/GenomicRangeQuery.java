
import java.util.*;

class GenomicRangeQuery  {
    public int[] solution(String S, int[] P, int[] Q) {
        int answer [] = new int[P.length];
       int count[][] = new int [S.length()][4];
       char c[] = S.toCharArray();
       for(int i = 0 ; i < c.length; i++){
           if( i != 0 ){
               count[i] = count[i-1].clone();
           }
           if(c[i] == 'A'){
              count[i][0]++;
           }        
           if(c[i] == 'C'){
              count[i][1]++;
           } 
           if(c[i] == 'G'){
              count[i][2]++;
           }   
           if(c[i] == 'T'){
              count[i][3]++;
           }
       }

       for(int i = 0; i < P.length; i++){
            int ans = 0;
           for(int j = 0; j < 4 ; j++){
              if(P[i] == 0){
                  if(count[Q[i]][j] > 0){ //시작점이 0부터
                      ans = j;
                      break;
                  }
              }
              else{
                      int num = count[Q[i]][j] - count[P[i]-1][j];
                      if(num > 0){
                          ans = j;
                          break;
                      }
                  }
           }
            answer[i] = ans+1;
       }
       return answer;
    }
}