package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9177_단어섞기 {
	static char[] word1, word2, word3;
	static String ans = "";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			word1 = st.nextToken().toCharArray();
			word2 = st.nextToken().toCharArray();
			word3 = st.nextToken().toCharArray();
			ans = "no";
			bfs();
			System.out.println("Data set " + tc + ": " + ans);
		}
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean visit[][] = new boolean[word1.length+1][word2.length+1];
		queue.add(new Point(0, 0));
		visit[0][0] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int aIdx = p.x;
			int bIdx = p.y;
			if(aIdx + bIdx == word3.length) {
				ans = "yes";
				break;
			}
			if(aIdx < word1.length && word3[aIdx+bIdx] == word1[aIdx] && !visit[aIdx+1][bIdx]) {
				visit[aIdx+1][bIdx] = true;
				queue.add(new Point(aIdx+1, bIdx));
			}
			if(bIdx < word2.length && word3[aIdx+bIdx] == word2[bIdx] && !visit[aIdx][bIdx+1]) {
				visit[aIdx][bIdx+1] = true;
				queue.add(new Point(aIdx, bIdx+1));
			}
		}
	}
}
