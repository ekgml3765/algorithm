package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1068_트리 {
	static List<Integer> list[];
	static int N, delNode, ans, root;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		list = new ArrayList[N];
		ans = 0;
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num != -1) {
				list[num].add(i);
			}else {
				root = i;
			}
		}
		delNode = Integer.parseInt(in.readLine());
		list[delNode] = new ArrayList<>();
		if(delNode != root)
			dfs(root);
		System.out.println(ans);	
	}
	public static void dfs(int num) {
		boolean flag = false;		
		for(int node : list[num]) {
			if(node == delNode)
				continue;
			dfs(node);
			flag = true;
		}
		//사이즈가 0이면 리프노드야.
		if(!flag) {
			ans++;
		}
	}
}
