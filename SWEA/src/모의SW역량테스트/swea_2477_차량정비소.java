package 모의SW역량테스트;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_2477_차량정비소 {

	static int ans, N, M, K, A, B;
	static Queue<person> list;
	static person [] customer;
	static Point a[], b[];
	static class person{
		int num, t, A, B, endA, endB;
		public person(int num, int t) {
			this.num = num;
			this.t = t;
		}
	}
	static class Node implements Comparable<Node>{
		int t, num, A;
		public Node(int t, int num, int A) {
			this.t = t;
			this.num = num;
			this.A = A;
		}
		@Override
		public int compareTo(Node o) {
			if(this.t == o.t) {
				return this.A - o.A;
			}
			return this.t - o.t;
		}
	}
	static PriorityQueue<Integer> queue1;
	static PriorityQueue<Node> queue2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			ans = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); //고객수
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			a = new Point[N+1];
			b = new Point[M+1];
			list = new LinkedList<person>();
			customer = new person[K+1];
			st = new StringTokenizer(in.readLine());
			for(int i = 1; i <= N; i++) {
				a[i] = new Point(Integer.parseInt(st.nextToken()), 0);
			}
			st = new StringTokenizer(in.readLine());
			for(int i = 1; i <= M; i++) {
				b[i] = new Point(Integer.parseInt(st.nextToken()), 0);
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= K; i++) {
				person p = new person(i, Integer.parseInt(st.nextToken()));
				customer[i] = p;
				list.add(p);
			}
			int t = 0;
			queue1 = new PriorityQueue<>();
			queue2 = new PriorityQueue<>();
			int cnt = 0;
			while(true) {
				if(cnt == K)
					break;
				//접수창고, 웨이팅
				while(!list.isEmpty() && list.peek().t == t) {
					queue1.add(list.poll().num);
				}
				//접수 창고 빠져나갈 애들 있는지 확인
				for (int i = 1; i <= N; i++) {
					int num = a[i].y;
					if(num > 0 && customer[num].endA == t) {
						a[i].y = 0;
						queue2.add(new Node(t, num, customer[num].A));
					}
				}	
				//접수창고 넣음
				for (int i = 1; i <= N; i++) {
					if(a[i].y == 0 && !queue1.isEmpty()) {
						int num = queue1.poll();
						a[i].y = num;
						customer[num].A = i;
						customer[num].endA = t + a[i].x;
					}
				}
				//장비창고 빠져나갈 애들 있는지 확인
				for (int i = 1; i <= M; i++) {
					int num = b[i].y;
					if(num > 0 && customer[num].endB == t) {
						b[i].y = 0;
						if(customer[num].A == A && customer[num].B == B)
							ans += num;
						cnt++;
					}
				}
				//장비창고 넣음
				for (int i = 1; i <= M; i++) {
					if(b[i].y == 0 && !queue2.isEmpty()) {
						int num = queue2.poll().num;
						b[i].y = num;
						customer[num].B = i;
						customer[num].endB = t + b[i].x;
					}
				}	
				t++;
			}
			ans = (ans==0)? -1 : ans;
			System.out.println("#" + tc + " " + ans);
		}
	}
}
