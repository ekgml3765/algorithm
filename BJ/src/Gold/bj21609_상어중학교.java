package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj21609_상어중학교 {

	
	static int map[][];
	static boolean visit[][];
	static int N, M, ans = 0;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static boolean flag = true;
	static class BlockGroup implements Comparable<BlockGroup>{
		int size, rainbowCnt, stan_r, stand_c;
		List<Point> blockList = new ArrayList<>();
		public BlockGroup(int size, int rainbowCnt, int stan_r, int stand_c, List<Point> blockList) {
			this.size = size;
			this.rainbowCnt = rainbowCnt;
			this.stan_r = stan_r;
			this.stand_c = stand_c;
			this.blockList = blockList;
		}
		
		
		@Override
		public int compareTo(BlockGroup o) {
			if(o.size == this.size) {
				if(o.rainbowCnt == this.rainbowCnt) {
					if(o.stan_r == this.stan_r) {
						return o.stand_c - this.stand_c; //열이 가장 큰
					}
					return o.stan_r - this.stan_r; //행이 가장 큰 
				}
				return o.rainbowCnt - this.rainbowCnt; //무지개 블록 수가 가장 많은
			}
			return o.size - this.size; //크기가 가장 큰
		}		
	}
	static class Node{
		int r,c,value;

		public Node(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}		
	}
	static List<BlockGroup> groupList;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
		
		//블록그룹이 존재하는 동안 반복
		while(true) {
			bfs();
			if(!flag)
				break;
			del();
			gravity();
			rotation();
			gravity();
		}
		System.out.println(ans);
		
	}
	
	//반시계
	private static void rotation() {
		int newMap[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			int arr[] = map[i];
			for (int j = 0; j < arr.length; j++) {
				newMap[j][i] = arr[N-1-j];
			}
		}
		for (int i = 0; i < newMap.length; i++) {
			map[i] = newMap[i].clone();
		}
	}

	private static void gravity() {

		for (int j = 0; j < N; j++) {
			Stack<Node> stack = new Stack<>();
			for (int i = 0; i < N; i++) {
				if(map[i][j] >= 0 ) {
					stack.add(new Node(i, j, map[i][j]));
				}
				if(!stack.isEmpty() && map[i][j] == -1) {
					//-1을 만날 경우
					int r = i-1;
					int c = j;
					while(!stack.isEmpty()) {
						Node node = stack.pop();
						map[node.r][node.c] = -2;
						map[r][c] = node.value;
						r--;
					}		
				}	
			}
			if(!stack.isEmpty()) {
				int r = N-1;
				int c = j;
				while(!stack.isEmpty()) {
					Node node = stack.pop();
					map[node.r][node.c] = -2;
					map[r][c] = node.value;
					r--;
				}	
			}
		}
	}

	//블록 그룹 제거
	private static void del() {
		List<Point> blockList = groupList.get(0).blockList;
		int size = groupList.get(0).size;
		for (Point point : blockList) {
			map[point.x][point.y] = -2;
			
		}
		ans += size*size;
	}

	//블록 그룹 찾기
	private static void bfs() {
		groupList = new ArrayList<BlockGroup>();
		visit = new boolean [N][N];
		
		//생성할 수 있는 블록그룹 생성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] > 0 && !visit[i][j]) { //일반 블록이면서 방문 안 한 블록일 경우
					Queue<Point> queue = new LinkedList<Point>();
					queue.add(new Point(i, j));
					visit[i][j] = true;
					List<Point> blockList = new ArrayList<>();
					List<Point> zeroList = new ArrayList<>();
					blockList.add(new Point(i, j));
					int rainbowCnt = 0;
					int stan_r = i;
					int stand_c = j;
					while(!queue.isEmpty()) {
						Point block = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nr = block.x + dr[d];
							int nc = block.y + dc[d];
							//범위밖
							if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
							//방문체크
							if(visit[nr][nc]) continue;
							if(map[nr][nc] == 0 || map[nr][nc] == map[i][j]) { //무지개거나 색상이 같거나
								
								visit[nr][nc] = true;
								//무지개블럭일 때
								if(map[nr][nc] == 0 ) {
									rainbowCnt++;
									queue.add(new Point(nr, nc));
									blockList.add(new Point(nr, nc));
									zeroList.add(new Point(nr, nc));
									continue;
								}
								
								//일반 블럭일 경우 - 기준 블록 정하기
								if(nr <= stan_r) {//같거나 작은 경우
									stan_r = nr;
									if(nr < stan_r) {
										stand_c = nc;
									}else {//행이 같은 경우
										if( nc < stand_c )
											stand_c = nc;
									}
								}
								blockList.add(new Point(nr, nc));
								queue.add(new Point(nr, nc));
							}
						}			
					}//end while
					
					//무지개 원상복귀
					for (Point point : zeroList) {
						visit[point.x][point.y] = false;
					}
					if(blockList.size() >= 2) {
						groupList.add(new BlockGroup(blockList.size(), rainbowCnt, stan_r, stand_c, blockList));
					}											
				}
			}
		}

		//list size 0이면 flag false -> 종료
		if(groupList.size() == 0) {
			flag = false;
			return;
		}
		
		//list 정렬
		Collections.sort(groupList);

	}
}
