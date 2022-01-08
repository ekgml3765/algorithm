package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj23290_마법사상어와복제{
	
	static int M, S, shark_r, shark_c;
	static int ddr[] = {-1, 0, 1, 0};//상좌하우
	static int ddc[] = {0, -1, 0, 1};
	static int dr[] = {0, -1, -1, -1, 0, 1, 1, 1 };
	static int dc[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static class Node implements Comparable<Node>{
		int fishCnt, r, c;
		String move;
		
		public Node(int r, int c, int fishCnt, String move) {
			this.r = r;
			this.c = c;
			this.fishCnt = fishCnt;
			this.move = move;
		}

		@Override
		public String toString() {
			return "Node [fishCnt=" + fishCnt + ", r=" + r + ", c=" + c + ", move=" + move + "]";
		}
		
		@Override
		public int compareTo(Node o) {
			if(o.fishCnt == this.fishCnt) {
				return this.move.compareTo(o.move);
			}
			return o.fishCnt - this.fishCnt;
		}
		
		
	}
	static List<Node> sharkList;
	static int smell[][];
	static HashMap<Point, List<Integer>> fish;
	static HashMap<Point, List<Integer>> copy;
	static int map[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		fish = new HashMap<>();
		smell = new int[4][4];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) -1;
			int c = Integer.parseInt(st.nextToken()) -1;
			int d = Integer.parseInt(st.nextToken()) -1;
			fish.computeIfAbsent(new Point(r,c), k -> new ArrayList<>()).add(d);
		}
		st = new StringTokenizer(in.readLine());
		shark_r = Integer.parseInt(st.nextToken())-1;
		shark_c = Integer.parseInt(st.nextToken())-1;
		//입력
		
		//S번 연습
		for (int t = 1; t <= S; t++) {
			copyFish(); //물고기 현재 위치 복사
			moveFish();//물고기 이동
			//상어 이동
			visit = new boolean[4][4];
			sharkList = new ArrayList<Node>();
			moveShark(shark_r, shark_c, 0, 0, "");
			makeSmell(t); //물고기 냄새 만들고 상어 이동
			removeSmell(t);//물고기 냄새 사라져		
			addFish(); //물고기 복제
		}
		
		//물고기 수
		int ans = 0;
		for(Point key : fish.keySet()) {
			ans += fish.get(key).size();
		}
		System.out.println(ans);
	}

	private static void addFish() {
		for (Point key : copy.keySet()) {
			if(fish.containsKey(key)) {
				fish.get(key).addAll(copy.get(key));
			}else {
				fish.put(key, copy.get(key));
			}
		}
	}

	private static void copyFish() {
		copy = new HashMap<Point, List<Integer>>();
		copy = (HashMap<Point, List<Integer>>) fish.clone();
	}
	
	
	private static void moveFish() {
		HashMap<Point, List<Integer>> newfish = new HashMap<Point, List<Integer>>();
		map = new int[4][4];
		for ( Point key : fish.keySet()) {
			List<Integer> list = fish.get(key);
			out: for (int i = 0; i < list.size(); i++) {
				int dir = list.get(i);
				for (int d = 0; d < 8; d++) {
					int nr = key.x + dr[dir];
					int nc = key.y + dc[dir];
					if(nr < 0 || nc < 0|| nr >= 4 || nc >= 4 || smell[nr][nc] != 0 || (nr == shark_r && nc == shark_c)) {
						dir = (dir-1 < 0) ? 7 : dir-1; //45도 방향 바꿈
						continue;
					}
					newfish.computeIfAbsent(new Point(nr, nc), k -> new ArrayList<>()).add(dir);
					map[nr][nc]++;
					continue out;
				}
				newfish.computeIfAbsent(new Point(key.x, key.y), k -> new ArrayList<>()).add(dir);
				map[key.x][key.y]++;
			}
		}
		fish = newfish;
	}
	

	private static void moveShark(int r, int c, int cnt, int fishCnt, String s) {
		if(cnt == 3) {
			List<Point> list = new ArrayList<>();
			Node node = new Node(r, c, fishCnt, s);
			sharkList.add(node);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + ddr[d];
			int nc = c + ddc[d];
			if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4 )
				continue;
			if(!visit[nr][nc]) {
				visit[nr][nc] = true;
				moveShark(nr, nc, cnt+1, fishCnt+map[nr][nc], s + Integer.toString(d));
				visit[nr][nc] = false;
			}else {
				moveShark(nr, nc, cnt+1, fishCnt, s + Integer.toString(d));
			}
			
		}
	}
	

	private static void makeSmell(int t) {
		Collections.sort(sharkList);
		Node node = sharkList.get(0);
		int nr = shark_r;
		int nc = shark_c;
		for (int i = 0; i < 3; i++) {
			int d = node.move.charAt(i) - '0';
			nr += ddr[d];
			nc += ddc[d];
			if(fish.containsKey(new Point(nr, nc))) {
				
				smell[nr][nc] = t + 2;
				fish.remove(new Point(nr, nc));
			}	
		}
		shark_r = node.r;
		shark_c = node.c;
	}
	

	private static void removeSmell(int t) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(smell[i][j] == t )
					smell[i][j] = 0;
			}
		}
		
	}
}
