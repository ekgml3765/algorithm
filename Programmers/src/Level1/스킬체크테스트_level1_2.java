package Level1;

public class 스킬체크테스트_level1_2 {
    public int solution(int[][] sizes) {
        int a = 0;
        int b = 0;
        for(int i = 0; i < sizes.length; i++){
            int big = Math.max(sizes[i][0], sizes[i][1]);
            int small = Math.min(sizes[i][0], sizes[i][1]);
            a = Math.max(a, big);
            b = Math.max(b, small);

        }
        return a*b;
    }
}
