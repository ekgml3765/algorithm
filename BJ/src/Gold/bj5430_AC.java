package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class bj5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		out : for (int tc = 0; tc < T; tc++) {
			String p = br.readLine();
			char[] order = p.toCharArray();
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			if(n==0) {
				if(p.contains("D"))
					System.out.println("error");
				else {
					System.out.println("[]");
				}
				continue;
			}
			s = s.substring(1, s.length()-1);
			StringTokenizer st = new StringTokenizer(s,",");
			Deque<Integer>deque = new LinkedList<Integer>();		
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			boolean dir = true; //true면 왼쪽,false면 오른쪽
			//명령
			for (int i = 0; i < order.length; i++) {
				if(order[i] == 'R') {
					dir = !dir;
				}else {
					if(deque.size() == 0) {
						System.out.println("error");
						continue out;
					}else {
						if(dir)
							deque.pollFirst();
						else
							deque.pollLast();
					}
				}
			}
			if(dir) {
				System.out.println(deque.toString().replace(" ", ""));
			}else {
				System.out.print("[");
				while(deque.size() > 1)
					System.out.print(deque.pollLast()+",");
				System.out.print(deque.getFirst());
				System.out.println("]");
			}	
		}
		
	}
}
