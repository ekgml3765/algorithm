package Level1;

import java.util.Arrays;
import java.util.Collections;

public class 정수내림차순으로배치하기 {
    public long solution(long n) {
        char carr[] = Long.toString(n).toCharArray();
        Arrays.sort(carr);
        StringBuilder sb = new StringBuilder(new String(carr, 0, carr.length));
        long answer =  Long.parseLong(sb.reverse().toString());
    return answer;
}
}
