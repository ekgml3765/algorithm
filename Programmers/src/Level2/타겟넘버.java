package Level2;

import java.io.IOException;
import java.util.Arrays;

public class 타겟넘버 {

	public static void main(String[] args) throws IOException {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		solution(numbers, target);
	}

	static int cnt, targetNum;
	static boolean check[];
	static int arr[];
	public static void powerSet(int idx) {
		if(idx == check.length) {
			int sum = 0;
			for (int i = 0; i < check.length; i++) {
				if(check[i]) {
					sum += arr[i];
				}else {
					sum -= arr[i];
				}
			}
			if(sum == targetNum) {
				cnt++;
			}
			return;
		}
		check[idx] = true;
		powerSet(idx+1);
		check[idx] = false;
		powerSet(idx+1);
		
	}
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		check = new boolean [numbers.length];
		arr = numbers;
		targetNum = target; 
		cnt = 0;
		powerSet(0);
		answer = cnt;
		System.out.println(answer);
		return answer;
	}
}
