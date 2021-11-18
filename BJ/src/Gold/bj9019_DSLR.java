package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9019_DSLR {
	static class Node {
		int num;
		String s;

		public Node(int num, String s) {
			this.num = num;
			this.s = s;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder ans = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			boolean visit[] = new boolean[10000];
			visit[A] = true;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(new Node(A, ""));
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				if (node.num == B) {
					ans.append(node.s + "\n");
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nextNum = 0;
					String s = "";
					switch (i) {
					case 0: {
						nextNum = (node.num * 2) % 10000;
						s = "D";
						break;
					}
					case 1: {
						nextNum = (node.num - 1 < 0) ? 9999 : node.num - 1;
						s = "S";
						break;
					}
					case 2: {
						nextNum = (node.num % 1000) * 10 + (node.num/1000);
						s = "L";
						break;
					}
					case 3: {
						nextNum = (node.num % 10) * 1000 + node.num / 10;
						s = "R";
						break;
					}
					}
					if (visit[nextNum])
						continue;
					visit[nextNum] = true;
					queue.add(new Node(nextNum, node.s+s));
				}
			}
		}
		System.out.println(ans);
	}
}
