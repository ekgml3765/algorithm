package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1707_이분그래프 {

	static int V, E;
	static List<Integer> list[];
	static int color[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < K; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V+1];
			color = new int[V+1];
			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}//입력끝
			boolean flag = false;
			for (int i = 1; i < list.length ; i++) {
					if(color[i] == 0) {
						if(!bfs(i)) {
							flag = true;
							break;
						}
					}
			}
			if(flag)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
	
	private static boolean bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		color[v] = 1;
		while(!queue.isEmpty()) {
			Integer vNum = queue.poll();
			for (int i = 0; i < list[vNum].size(); i++) {
				int other = list[vNum].get(i);
				if(color[other] == 0) {
					color[other] = color[vNum] * -1;
					queue.add(other);
				}
				if(color[other] == color[vNum]) {
					return false;
				}
			}
		}
		return true;
	}
}
