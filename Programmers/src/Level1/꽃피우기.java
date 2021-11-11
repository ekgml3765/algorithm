package Level1;

import java.util.LinkedList;
import java.util.Queue;

class 꽃피우기 {
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static class Node{
        int r, c, cnt;
        public Node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] garden) {
        // 여기에 코드를 작성해주세요.  
        int answer = 0;
        int N = garden.length;
        int M = garden[0].length;
        Queue<Node> queue = new LinkedList<Node>();
        boolean visit[][] = new boolean[N][M];
        for(int i = 0 ; i < garden.length; i++){
            for(int j = 0; j < garden.length; j++){
                if(garden[i][j] == 1){
                    visit[i][j] = true;
                    queue.add(new Node(i, j, 0));
                }
            }
        }
        while(!queue.isEmpty()){
            Node node = queue.poll();
            answer = Math.max(node.cnt, answer);
            for(int d = 0; d < 4; d++){
                int nr = node.r + dr[d];
                int nc = node.c + dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || garden[nr][nc] == 1)
                    continue;
                visit[nr][nc] = true;
                garden[nr][nc] = 1;
                queue.add(new Node(nr, nc, node.cnt+1));      
            }
        }
     
        return answer;
    }
   
}