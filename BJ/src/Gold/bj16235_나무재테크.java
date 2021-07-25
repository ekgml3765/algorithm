package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj16235_나무재테크 {

	static int N, M, K, ans = 0;
	static class Tree implements Comparable<Tree>{
		int r, c, age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	static class Land{
		int food = 5;
		List<Tree> treeList = new ArrayList<>();
	}
	static Land map[][];
	static int A[][];
	static List<Tree> deadList;
	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Land[N][N];
		A = new int[N][N]; //양분 추가되는 양
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new Land();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			map[r][c].treeList.add(new Tree(r, c, age));
		}//입력 끝
		
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += map[i][j].treeList.size();
			}
		}
		System.out.println(ans);
	}
	private static void winter() { //양분 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j].food += A[i][j];
			}
		}	
	}
	private static void fall() { //나무 번식
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = map[i][j].treeList.size();
				if(size > 0) {
					int cnt = 0;
					for (int k = 0; k < size; k++) {
						if(map[i][j].treeList.get(k).age % 5 == 0) {//나무의 나이가 5의배수이면
							cnt++;
						}
					}
					if(cnt > 0) {
						for (int d = 0; d < 8; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
							for (int k = 0; k < cnt; k++) {
								map[nr][nc].treeList.add(new Tree(nr, nc, 1));
							}
						}
					}
				}
			}
		}
		
	}
	private static void summer() { //죽은 나무 양분으로
		for (Tree tree : deadList) {
			map[tree.r][tree.c].food += tree.age/2;
		}
	}
	private static void spring() {//나무 처리
		deadList = new ArrayList<>();
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].treeList.size() > 0) {
					Collections.sort(map[i][j].treeList); //나이 어린 순 정렬
					List<Tree> newTreeList = new ArrayList<>();
					int food = map[i][j].food; //해당 칸 양분
					for (int k = 0; k < map[i][j].treeList.size(); k++) {
						Tree tree = map[i][j].treeList.get(k);
						if(food < 0)
							break;
						if(tree.age <= food) {
							food -= tree.age; //자신의 나이 만큼 양분 먹고
							tree.age++;
							newTreeList.add(tree);
						}else {//죽어야하는 나무
							deadList.add(tree);
						}
					}
					map[i][j].treeList = newTreeList;
					map[i][j].food = food;
				}
			}
		}
	}
}
