package Level1;

import java.util.HashSet;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        answer = (set.size() >= answer)? answer : set.size();
        return answer;
    }
}
