package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj17140_이차원배열과연산_2회독 {

	static int r, c, k;
	static int map[][];
	static class Node implements Comparable<Node>{
		int num, cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if(this.cnt == o.cnt) {
				return this.num - o.num;
			}
			return this.cnt - o.cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		map = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = -1;
		int time = 0;
		while(time <= 100) {
			if(( r < map.length && c < map[0].length) && map[r][c] == k) {
				ans = time;
				break;
			}
			int R = map.length;
			int C = map[0].length;
			if(R >= C) {
				row();
			}else {
				col();
			}
			time++;
		}
		System.out.println(ans);
	}
	private static void col() {
		List<Integer> list[] = new ArrayList[map[0].length];
		int max = map.length;
		int R = map.length;
		int C = map[0].length;
		for (int i = 0; i < C; i++) {
			List<Node> arr = new ArrayList<>();
			List<Integer> number = new ArrayList<>();
			HashMap<Integer, Integer> hash = new HashMap<>();
			for (int j = 0; j < R; j++) {
				if(map[j][i] == 0)
					continue;
				hash.put(map[j][i], hash.getOrDefault(map[j][i], 0)+1);
			}
			for (Integer key : hash.keySet()) {
				Node node = new Node(key, hash.get(key));
				arr.add(node);
			}
			Collections.sort(arr);
			
			//길이 100넘으면 처리
			int size = (arr.size() > 50)? 50 : arr.size();
			for (int j = 0; j < size; j++) {
				Node node = arr.get(j);
				number.add(node.num);
				number.add(node.cnt);
			}
			max = Math.max(max, size*2);
			list[i] = number;
		}
		map = new int[max][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				map[j][i] = list[i].get(j);
			}
		}	
		
	}
	private static void row() {
		List<Integer> list[] = new ArrayList[map.length];
		int max = map[0].length;
		int R = map.length;
		int C = map[0].length;
		for (int i = 0; i < R; i++) {
			List<Node> arr = new ArrayList<>();
			List<Integer> number = new ArrayList<>();
			HashMap<Integer, Integer> hash = new HashMap<>();
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 0)
					continue;
				hash.put(map[i][j], hash.getOrDefault(map[i][j], 0)+1);
			}
			for (Integer key : hash.keySet()) {
				Node node = new Node(key, hash.get(key));
				arr.add(node);
			}
			Collections.sort(arr);
			
			//길이 100넘으면 처리
			int size = (arr.size() > 50)? 50 : arr.size();
			for (int j = 0; j < size; j++) {
				Node node = arr.get(j);
				number.add(node.num);
				number.add(node.cnt);
			}
			max = Math.max(max, size*2);
			list[i] = number;
		}
		map = new int[R][max];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				map[i][j] = list[i].get(j);
			}
		}	
	}
}
