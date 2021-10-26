package Level2;

import java.util.*;

public class 월간코드챌린지_n2배열자르기 {
    public int[] solution(int n, long left, long right) {
		int size = (int) (right - left + 1);
        int[] answer = new int[size];
		int idx = 0;
		int r = (int) (left / n);
		int c = (int) (left % n);
		int R = (int) (right / n);
		int j = (int) c;
		out: for (int i = r; i <= R; i++) {
			while (j < n) {
				int num = (j <= i) ? i + 1 : j + 1;
				answer[idx] = num;
				j++;
				idx++;
				if (idx >= size)
					break out;
			}
			j = 0;
		}
		return answer;
    }
}
