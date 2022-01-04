package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj20920_영단어암기는괴로워 {
	static class Node implements Comparable<Node>{
		String s;
		int cnt, len;

		public Node(String s, int cnt, int len) {
			this.s = s;
			this.cnt = cnt;
			this.len = len;
		}
		@Override
		public int compareTo(Node o) {
			if(o.cnt == this.cnt) {
				if(o.len == this.len)
					return this.s.compareTo(o.s);
				return o.len - this.len;
			}
			return o.cnt-this.cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			if(s.length() >= M) {
				map.put(s, map.getOrDefault(s, 0)+1);
			}
		}
		List<Node> list = new ArrayList<>();
		for(String key : map.keySet()) {
			list.add(new Node(key, map.get(key), key.length()));
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (Node node : list) {
			sb.append(node.s + "\n");
		}
		System.out.println(sb);
	}
}
