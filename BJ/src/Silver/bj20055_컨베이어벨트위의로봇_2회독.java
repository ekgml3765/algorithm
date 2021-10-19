package Silver;

import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20055_컨베이어벨트위의로봇_2회독 {
	static int N, K;
	static Node[] map;
	static class Node {
		int a;
		boolean robot = false;
		public Node(int a) {
			this.a = a;
		}
		@Override
		public String toString() {
			return "Node [a=" + a + ", robot=" + robot + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Node[2*N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < map.length; i++) {
			map[i] = new Node(Integer.parseInt(st.nextToken()));
		}
		int t = 1;
		while(true) {
			rotation();
			move();
			up();
			if(check())
				break;
			t++;
		}
		System.out.println(t);
	}
	private static void rotation() {
		Node tmp = map[map.length-1];
		for (int i = map.length-1; i > 0; i--) {
			map[i] = map[i-1];
		}
		map[0] = tmp;
		if(map[N-1].robot) {
			map[N-1].robot = false;
		}
	}
	private static void move() {
		for (int i = N-2; i >= 0; i--) {
			if(map[i].robot) {
				int next = (i+1)%(2*N);
				if(map[next].a >= 1 && !map[next].robot) {
					map[i].robot = false;
					map[next].robot = true;
					map[next].a--;
					if(next == N-1)
						map[next].robot = false;
				}
			}
		}
		
	}
	private static void up() {
		if(map[0].a != 0) {
			map[0].robot = true;
			map[0].a--;
		}
	}
	private static boolean check() {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			if(map[i].a == 0)
				cnt++;
		}
		if(cnt >= K)
			return true;
		return false;
	}
}
