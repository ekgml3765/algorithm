package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15658_연산자끼워넣기_2 {
	static int N, arr[], max, min, op[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		op = new int[4];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1, arr[0]);
		System.out.println(max + "\n" + min);
	}
	private static void dfs(int idx, int num) {
		if(idx == arr.length) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				
				switch(i) {
				case 0:{
					dfs(idx+1, num+arr[idx]);
					break;
				}
				case 1:{
					dfs(idx+1, num-arr[idx]);
					break;
				}
				case 2:{
					dfs(idx+1, num*arr[idx]);
					break;
				}
				case 3:{
					dfs(idx+1, num/arr[idx]);
					break;
				}
				}
				op[i]++;
			}
		}
		
	}
}
