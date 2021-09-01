package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 쿼드압축후개수세기 {
    static int dr[] = {0, 1, 1};
	static int dc[] = {1, 1, 0};
	public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int size = arr.length;
        if(size == 1) {
        	answer[1] = (arr[0][0]==1)? 1 : answer[0]++;
        	return answer;
        }
        int map[][] = new int [size][size];
        for (int i = 0; i < size; i++) {
			map[i] = arr[i].clone();
		}
        while(true) {   	
        	List<Integer> list = new ArrayList<Integer>();
        	for (int i = 0; i < map.length; i+=2) {
        		for (int j = 0; j < map.length; j+=2) {
        			int zero = 0;
        			int one = 0;
        			if(map[i][j] == 0 || map[i][j] == 1)
        				zero = (map[i][j]==0)? 1 : one++;
					for (int d = 0; d < 3; d++) {
						int n = map[i+dr[d]][j+dc[d]];
						if(n == -1)
							continue;
						if(n == 0)
							zero++;
						else
							one++;		
					}
					if(zero == 4 || one == 4) {
						list.add(map[i][j]);
					}else {
						list.add(-1);
						answer[0] += zero;
						answer[1] += one;
					}
				}
			}
        	size /= 2;
        	map = new int[size][size];
        	int idx = 0;
        	for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = list.get(idx);
					idx++;
				}
			}
            if(size == 1) {
        		if(map[0][0] != -1)
        			answer[1] = (map[0][0]==1)? 1 : answer[0]++;
        		break;
        	}
        }
        return answer;
    }
}
