package Level1;

import java.util.Arrays;

public class K번째큰수 {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{2, 5, 3}, {4, 4, 1}, {1, 7, 3}
		};
		solution(array, commands);
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		  int[] answer = new int [commands.length];
		  for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int order = commands[i][2];
			int arr[] = new int[end-start+1];
			for (int idx = 0, j = start-1; j <= end-1; j++, idx++) {
				arr[idx] = array[j];
			}
			Arrays.sort(arr);
			answer[i] = arr[order-1];
		}
	      return answer;
	}
}
