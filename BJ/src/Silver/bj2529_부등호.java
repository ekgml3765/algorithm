package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj2529_부등호 {
	static int k, sel[];
	static char arr[];
	static boolean check[];
	static List<String> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		arr = new char[k];
		for (int i = 0; i < k; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		list = new ArrayList<String>();
		check = new boolean[10];
		sel = new int[k+1];
		dfs(0);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
	private static void dfs(int idx) {
		if(idx == k+1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]);
			}
			list.add(sb.toString());
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if(!check[i]) {
				if(idx > 0) {
					int num = sel[idx-1];
					char c = arr[idx-1];
					if(c == '<') {
						if(num > i)
							continue;
					}else {
						if(num < i)
							continue;
					}
				}
				check[i] = true;
				sel[idx] = i;
				dfs(idx+1);
				check[i] = false;
			}
		}
		
	}
}
