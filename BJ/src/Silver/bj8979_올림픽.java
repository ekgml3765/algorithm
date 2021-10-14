package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj8979_올림픽 {
	static class Node implements Comparable<Node>{
		int num, g, s, b;

		public Node(int num, int g, int s, int b) {
			this.num = num;
			this.g = g;
			this.s = s;
			this.b = b;
		}

		@Override
		public int compareTo(Node o) {
			if(o.g == this.g) {
				if(o.s == this.s)
					return o.b - this.b;
				return o.s - this.s;
			}
			return o.g - this.g;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Node> list = new ArrayList<Node>();
		int ans[] = new int[N+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Node(num, g, s, b));
		}
		Collections.sort(list);
		int idx = 1;
		int rank = 1;
		int score1 = (list.get(0).g*3) + (list.get(0).s*2) + list.get(0).b;
		for (Node node : list) {
			int num = node.num;
			int score2 = (node.g*3) + (node.s*2) + node.b;
			if(score1 == score2) {
				ans[node.num] = rank;
			}else {
				score1 = score2;
				ans[node.num] = idx;
				rank = idx;
			}
			idx++;
		}
		System.out.println(ans[M]);
	}
}
