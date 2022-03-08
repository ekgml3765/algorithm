package Level2;

import java.util.*;
class 배달 {
    static boolean visit[], check[];
    static int map[][];
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        map = new int[N][N];
        visit = new boolean[N];
        check = new boolean[N];
        for(int i = 0; i < road.length; i++){
            int a = road[i][0]-1;
            int b = road[i][1]-1;
            int c = road[i][2];
            if(map[a][b] != 0 && c > map[a][b] )
                continue;
            map[a][b] = c;
            map[b][a] = c;
        }
        visit[0] = true;
        check[0] = true;
        dfs(0, 0, N, K);
        for(int i = 0; i < N; i++){
            if(check[i])
                answer++;
        }
        return answer;
    }
    static void dfs(int i, int sum, int N, int K){
        for(int j = 0; j < N; j++){
            if(map[i][j] != 0 && !visit[j] && sum+map[i][j] <= K){
                check[j] = true; //한번이라도 방문을 했으면
                visit[j] = true;
                dfs(j, sum+map[i][j], N, K);
                visit[j] = false;   
            }
        }
    }
}