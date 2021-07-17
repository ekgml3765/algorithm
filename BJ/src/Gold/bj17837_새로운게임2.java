package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj17837_새로운게임2 {

	static class Holes {
		int r, c, d, num;

		public Holes(int r, int c, int d, int num) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.num = num;
		}
	}

	static class Chase {
		int color;
		List<Holes> list;

		public Chase(int color, List<Holes> list) {
			this.color = color;
			this.list = list;
		}

	}

	static Chase map[][];
	static int N, K;
	static Holes[] holesList;
	static int dr[] = { 0, 0, -1, 1 };
	static int dc[] = { 1, -1, 0, 0 };
	static boolean flag;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine());

		//test();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Chase[N][N];
		holesList = new Holes[K + 1]; // 1번째말부터 시작.

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int color = Integer.parseInt(st.nextToken());
				map[i][j] = new Chase(color, new ArrayList<Holes>());
			}
		}

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			holesList[i] = new Holes(r, c, d, i);
			map[r][c].list.add(new Holes(r, c, d, i));
		}
		

		// 턴만큼 반복 - 1턴당 모든말
		int turn;
		flag = false;
		out: for (turn = 1; turn < 1001; turn++) {
			// 모든 말에 대해 살펴본다
			for (int j = 1; j <= K; j++) {
				letmove(holesList[j], j);
				if(flag) break out;
			}
		} // end for
		
		turn = (turn == 1001) ? -1 : turn;
		System.out.println(turn);
	}

	private static void letmove(Holes holes, int idx) {
		// 말 이동할 위치
		int nr = holes.r + dr[holes.d];
		int nc = holes.c + dc[holes.d];
		// 범위밖 파란색일 경우
		if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc].color == 2) {
			// 반대 방향으로 바꾸고
			int d = 0;
			if (holes.d == 0) {
				d = 1;
			}
			if (holes.d == 1) {
				d = 0;	
			}
			if (holes.d == 2) {
				d = 3;
			}
			if (holes.d == 3) {
				d = 2;
			}
			holesList[idx].d = d;
			// 반대 방향에 색에 따라 확인.
			int nnr = holes.r + dr[holes.d];
			int nnc = holes.c + dc[holes.d];
			// 해당 방향이 범위밖이나 파란색이면 해당 자리 그냥 스테이
			if (nnr < 0 || nnc < 0 || nnr >= N || nnc >= N || map[nnr][nnc].color == 2) {
				return;	
			}
			if(map[nnr][nnc].color == 0) {
				move(holes.r, holes.c, nnr, nnc, holes.num);
				return;
			}
				
			if(map[nnr][nnc].color == 1) {
				move(holes.r, holes.c, nnr, nnc, holes.num);
				return;
			}
				
			
		}
		//System.out.println(nr + " " + nc);
		// 하얀색 일 경우 이동
		if(map[nr][nc].color == 0) {
			move(holes.r, holes.c, nr, nc, holes.num);
		}
		// 빨간색 일 경우 이동
		if(map[nr][nc].color == 1) {
			move(holes.r, holes.c, nr, nc, holes.num);
		}
	
	}

	private static void move(int r, int c, int nr, int nc, int num) {
		int color = map[nr][nc].color;
		int idx = 0; //현재 내 num의 list인덱스 찾음
		List<Holes> subList1 = new ArrayList<Holes>();
		List<Holes> subList2 = new ArrayList<Holes>();
		for (int i = 0; i < map[r][c].list.size(); i++) {
			if(map[r][c].list.get(i).num == num)
				idx = i;
		}
		subList1 = map[r][c].list.subList(0, idx); //기존에 있을 애	
		if(color == 0) { //하얀색 일 경우
			subList2 = map[r][c].list.subList(idx, map[r][c].list.size());
		}if(color == 1) {//빨간색 일경우 
			subList2 = map[r][c].list.subList(idx, map[r][c].list.size());
			Collections.reverse(subList2); //순서 반대로 뒤집어		
		}
	
		for (int i = 0; i < subList2.size(); i++) {
			//행, 열 이동
			int num_holes = subList2.get(i).num;
			holesList[num_holes].r = nr;
			holesList[num_holes].c = nc;
		}

		map[nr][nc].list.addAll(subList2); //추가해
		map[r][c].list = subList1; //기존꺼 다시 수정
		//이동후 그때 말이 4개라면 종료
		if(map[nr][nc].list.size() >= 4) {
			flag = true;
		}
			
	}
}
