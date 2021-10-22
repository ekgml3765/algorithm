package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj2668_숫자고르기 {
	static int N, arr[], sel[];
	static boolean visit[];
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		visit = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			visit[i] = true;
			dfs(i, i);
			visit[i] = false;
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
	private static void dfs(int to, int num) {
		if(!visit[arr[to]]) {
			visit[arr[to]] = true;
			dfs(arr[to], num);
			visit[arr[to]] = false;
		}
		if(arr[to] == num)
			list.add(num);
	}

}
