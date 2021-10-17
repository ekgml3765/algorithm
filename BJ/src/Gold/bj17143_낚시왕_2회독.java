package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj17143_낚시왕_2회독 {
	static int R, C, M, map[][],newMap[][],ans;
	static class Node{
		int r, c, s, d, z;
		public Node(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}		
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, 1, -1};
	static HashMap<Integer, Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		ans = 0;
		list = new HashMap<Integer, Node>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			if(d == 0 || d==1) {
				s = s % ((R-1)*2);
			}
			if(d == 2 || d == 3) {
				s = s % ((C-1)*2);
			}
			map[r][c] = i;
			list.put(i, new Node(r, c, s, d, z));
		}//입력 끝
		for (int j = 0; j < C; j++) {
			//상어 잡아
			ans += shark(j);
			//상어이동
			move();
		}
		System.out.println(ans);
		
	}
	private static void move() {
		newMap = new int[R][C];
		//이동
		List<Integer> removeList = new ArrayList<>();
		for (Integer num : list.keySet()) {
			Node node = list.get(num);
			for (int i = 0; i < node.s; i++) {
				int nr = node.r + dr[node.d];
				int nc = node.c + dc[node.d];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
					node.d = (node.d%2 == 0)? node.d+1 : node.d-1;
					nr = node.r + dr[node.d];
					nc = node.c + dc[node.d];					
				}
				node.r = nr;
				node.c = nc;
			}
			list.put(num, node);
			if(newMap[node.r][node.c] == 0) {
				newMap[node.r][node.c] = num;
			}else {
				int num2 = newMap[node.r][node.c];
				if(list.get(num2).z < node.z) {
					removeList.add(num2);
					newMap[node.r][node.c] = num;
				}else {
					removeList.add(num);
				}
			}
		}
		//죽을 상어 죽여
		for (Integer num : removeList) {
			list.remove(num);
		}
		for (int i = 0; i < map.length; i++) {
			map[i] = newMap[i].clone();
		}
	}
	private static int shark(int j) {
		for (int i = 0; i < R; i++) {
			if(map[i][j] != 0) {
				int num = map[i][j];
				int size = list.get(num).z;
				map[i][j] = 0;
				list.remove(num);
				return size;	
			}
		}
		return 0;
	}
}
