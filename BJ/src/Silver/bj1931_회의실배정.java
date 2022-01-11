package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1931_회의실배정 {
	 
	static class Node implements Comparable<Node>{
		int s, e;
		public Node(int s, int e) {
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Node o) {
			if(this.e == o.e)
				return this.s-o.s;
			return this.e - o.e;
		}
	}
	 public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Node list[] = new Node[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[i] = new Node(s, e);
		}
		Arrays.sort(list);
		int ans = 1;
		int e = list[0].e;
		for (int i = 1; i < list.length; i++) {
			if(list[i].s >= e) {
				ans++;
				e = list[i].e;
			}
		}
		System.out.println(ans);	
		
	}
}
