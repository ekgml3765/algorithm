package Level3;

public class 그래프_순위 {

    public int solution(int n, int[][] results) {
        int answer = 0;
        int map[][] = new int[n][n];
        for(int i = 0; i < results.length; i++){
            map[results[i][0]-1][results[i][1]-1] = 1;
        }
        
        //플로이드 와샬
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][k]== 1 && map[k][j] == 1)
                        map[i][j] = 1;
                }
            }
        }
        
        out: for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < n; j++){
                
                if(i == j)
                    continue;
                if(map[i][j] == 0 && map[j][i] == 0)
                    continue out;
            }
            answer++;
        }
        return answer;
    }
}
