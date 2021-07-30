package Level2;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {

	public static void main(String[] args) {
		int[] citations = {88, 89};
		solution(citations);
	}
    public static int solution(int[] citations) {
        int answer = 0;
        //내림차순 정렬
        citations = Arrays.stream(citations).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int max = citations[0];
        for (int h = max; h >= 1; h--) {
        	int cnt = 0;
			for (int i = 0; i < citations.length; i++) {
				if(citations[i] < h) 
					break;
				cnt++;
			}
			if(cnt >= h && citations.length - cnt <= h)
				answer = Math.max(answer, h);
		}
        return answer;
    }
}
