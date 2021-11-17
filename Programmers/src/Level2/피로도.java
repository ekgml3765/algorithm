package Level2;

public class 피로도 {
    static int ans = 0;
    static boolean visit[];
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        perm(0, k, dungeons, 0);
        return ans;
    }    
    public static void perm(int idx, int k, int[][] dungeons, int cnt){
        ans = Math.max(cnt, ans);
        if(idx == dungeons.length){
            return;
        }
        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i] && dungeons[i][0] <= k){
                visit[i] = true;
                perm(idx+1, k-dungeons[i][1], dungeons, cnt+1);
                visit[i] = false;
            }
        }
    }
}
