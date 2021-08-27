package Level2;

import java.util.HashSet;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 6; i++){
            set.add(win_nums[i]);
        }
        int zero = 0;
        int sameCnt = 0;
        for(int i = 0; i < 6; i ++){
            if(lottos[i] == 0)
                zero++;
            else{
                if(set.contains(lottos[i]))
                    sameCnt++;
            }
        }
        answer[0] = (7-(zero+sameCnt)==7)? 6 : 7-(zero+sameCnt);
        answer[1] = (7-(sameCnt)==7)? 6 : 7-(sameCnt);
        return answer;
    }
}
