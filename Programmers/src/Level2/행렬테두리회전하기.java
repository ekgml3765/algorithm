package Level2;

public class 행렬테두리회전하기 {
	static int map[][];
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		map = new int[rows][columns];
		int num = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = num;
				num++;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			int startR = queries[i][0] - 1;
			int startC = queries[i][1] - 1;
			int endR = queries[i][2] - 1;
			int endC = queries[i][3] - 1;
			answer[i] = move(startR, startC, endR, endC);
		}
		return answer;
	}

	public static int move(int startR, int startC, int endR, int endC) {
		int min = map[startR][endC];
		int tmp = map[startR][endC];
		// 오
		for (int j = endC; j > startC; j--) {
			map[startR][j] = map[startR][j - 1];
			min = Math.min(min, map[startR][j]);
		}
		// 위
		for (int i = startR; i < endR; i++) {
			map[i][startC] = map[i + 1][startC];
			min = Math.min(min, map[i][startC]);
		}
		// 왼
		for (int j = startC; j < endC; j++) {
			map[endR][j] = map[endR][j + 1];
			min = Math.min(min, map[endR][j]);
		}
		// 아래
		for (int i = endR; i > startR; i--) {
			map[i][endC] = map[i - 1][endC];
			min = Math.min(min, map[i][endC]);
		}
		map[startR + 1][endC] = tmp;
		return min;
	}
}
