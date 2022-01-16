package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj2075_N번째큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				pqueue.add(Integer.parseInt(st.nextToken()));
			}
		}
		int ans = 0;
		for(int i = 0 ; i < N; i++) {
			ans = pqueue.poll();
		}
		System.out.println(ans);
	}
}
