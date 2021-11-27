package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1167_트리의지름 {

	static class Node{
		int num, len;
		public Node(int num, int len) {
			this.num = num;
			this.len = len;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", len=" + len + "]";
		}
		
	}
	static List<Node>[] list;
	static int ans = 0, max = 0;
	static boolean visit[];
	static int longNode;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		list = new ArrayList[V+1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int b = Integer.parseInt(st.nextToken());
				if(b == -1)
					break;
				int len = Integer.parseInt(st.nextToken());
				list[a].add(new Node(b, len));
			}
		}
		visit = new boolean[V+1];
		visit[1] = true;
		dfs(1, 0);
		
		visit = new boolean[V+1];
		visit[longNode] = true;
		dfs(longNode, 0);
		System.out.println(ans);
	}
	
	private static void dfs(int num, int cnt) {
		if(cnt > ans) {
			ans = cnt;
			longNode = num;
		}
		for(Node node : list[num]) {
			if(!visit[node.num]) {
				visit[node.num] = true;
				dfs(node.num, cnt+node.len);
				visit[node.num] = false;
			}
		}
		
	}
}
