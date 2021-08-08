package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2644_촌수계산 {

	static int N, endR, endC, ans;
	static boolean visit[];
	static List<Integer> list[];
	static class Node{
		int num, cnt;
		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		visit = new boolean[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		endR = Integer.parseInt(st.nextToken())-1;
		endC = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(in.readLine());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			list[a].add(b);
			list[b].add(a);
		}	
		ans = -1;
		bfs(endR);
		System.out.println(ans);
	}
	private static void bfs(int go) {
		Queue<Node> queue = new LinkedList<Node>();
		visit[go] = true;
		queue.add(new Node(go, 0));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.num == endC) {
				ans = node.cnt;
				return;
			}
			for (int i = 0; i < list[node.num].size(); i++) {
				int num = list[node.num].get(i);
				if(!visit[num]) {
					visit[num] = true;
					queue.add(new Node(num, node.cnt+1));
				}
			}
		}
	}
}
