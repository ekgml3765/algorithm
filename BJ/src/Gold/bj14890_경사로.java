package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14890_경사로 {
	static int N, L, map[][], ans = 0;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		//행검사
		for (int i = 0; i < N; i++) {
			if (check(map[i]))
				ans++;
		}
		//열검사
		for (int j = 0; j < N; j++) {
			int arr[] = new int[N];
			for (int i = 0; i <N; i++) {
				arr[i] = map[i][j];
			}
			if(check(arr))
				ans++;
		}
		System.out.println(ans);
	}

	private static boolean check(int[] arr) {
		visit = new boolean[arr.length];
		int num = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != num) {
				if (Math.abs(arr[i] - num) > 1)
					return false;
				int dif = num - arr[i];
				boolean flag = go(i, dif, arr); // 경사로 놓을 수 있는지 체크
				if (!flag)
					return false;
				else
					num = arr[i];
			}
		}
		return true;
	}

	private static boolean go(int idx, int dif, int arr[]) {
		// 왼쪽에 경사로
		if (dif < 0) {
			int cnt = 0;
			int i = idx;
			while(cnt < L) {
				i--;
				if(i < 0 || i >= N || visit[i] || arr[i] != arr[idx]-1)
					return false;
				visit[i] = true;
				cnt++;
			}
		}
		// 오른쪽에 경사로
		else {
			int cnt = 0;
			int i = idx;
			while(cnt < L) {
				if(i < 0 || i >= N || visit[i] || arr[i] != arr[idx])
					return false;
				visit[i] = true;
				i++;
				cnt++;
			}
		}
		return true;
	}
}
