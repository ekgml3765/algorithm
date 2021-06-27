package Level2;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class 카펫 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int brown = sc.nextInt();
		int yellow = sc.nextInt();
		solution(brown, yellow);
	}

	static public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		//약수구하기
		int sq = (int)Math.sqrt(yellow);
		for (int i = 1; i <= sq; i++) {
			if(yellow % i == 0) {
				int r = i;
				int c = yellow / i;
				int cnt = (c+2)*2 + (r*2);
				if(cnt == brown) {
					answer[0] = c+2;
					answer[1] = r+2;
					break;
				}		
			}
		}
		return answer;
	}
}
