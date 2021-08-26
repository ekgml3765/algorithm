package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
	static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static class Node{
        int r, c, num;
        public Node(int r, int c, int num){
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        boolean visit[][] = new boolean [m][n];
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0 && !visit[i][j]){
                    answer[0]++;
                    visit[i][j] = true;
                    queue.add(new Node(i, j, picture[i][j]));
                    int cnt = 1;
                    while(!queue.isEmpty()){
                        Node node = queue.poll();
                        for(int d = 0; d < 4; d++){
                            int nr = node.r + dr[d];
                            int nc = node.c + dc[d];
                            if( nr < 0 || nc < 0 || nr >= m || nc >= n || visit[nr][nc])
                                continue;
                            if(picture[nr][nc] != node.num)
                                continue;
                            visit[nr][nc] = true;
                            queue.add(new Node(nr, nc, node.num));
                            cnt++;
                        }
                    }
                    answer[1] = Math.max(cnt, answer[1]);
                }
            }
        }
        return answer;
    }
}
