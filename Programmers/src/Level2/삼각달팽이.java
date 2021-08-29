package Level2;

import java.util.ArrayList;
import java.util.List;

public class 삼각달팽이 {
	public List<Integer> solution(int n) {
		int map[][] = new int[n][n];
		int r = -1, c = 0;
		int d = 0;
		int num = 1;
		while (n != 0) {
			for (int i = 0; i < n; i++) {
				if (d == 0) {
					map[r + 1][c] = num;
					r++;
				}
				if (d == 1) {
					map[r][c + 1] = num;
					c++;
				}
				if (d == 2) {
					map[r - 1][c - 1] = num;
					r--;
					c--;
				}
				num++;
			}
			n--;
			d = (d + 1) % 3;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 0)
					break;
				list.add(map[i][j]);
			}
		}
		return list;
	}
}
