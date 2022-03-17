package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj11000_강의실배정 {
	static class Node implements Comparable<Node>{
		int s, t;
		Node(int s, int t){
			this.s = s;
			this.t = t;
		}
		@Override
		public int compareTo(Node o) {
			if(this.s == o.s)
				return this.t-o.t;
			return this.s - o.s;
		}
		@Override
		public String toString() {
			return "Node [s=" + s + ", t=" + t + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Node lecture[] = new Node[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			lecture[i] = new Node(s, t);
		}
		Arrays.sort(lecture);
		int ans = 0;
		pq.add(lecture[0].t);
		for(int i = 1; i < N; i++) {
			if(pq.peek() <= lecture[i].s) {
				pq.poll();
			}
			pq.add(lecture[i].t);
		}
		System.out.println(pq.size());
	}
}
