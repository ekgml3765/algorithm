package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj17825_윷놀이 {
	static int map[][] = {
			{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, -1},
			{10, 13, 16, 19}, //10
			{20, 22, 24}, //20
			{30, 28, 27, 26}, //30
			{25, 30, 35, 40, -1} //겹침
	};
	static int order[];
	static int ans = 0;
	static class Holes{
		int r, c;
		public Holes(int r, int c) {
			this.r = r;
			this.c = c;
		}	
	}
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		order = new int[10];
		for (int i = 0; i < 10; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}//입력 끝
		Holes[] list = new Holes[4];
		for (int i = 0; i < 4; i++) {
			list[i] = new Holes(0, 0);
		}
		visit = new boolean[5][];
		for (int i = 0; i < 5; i++) {
			visit[i] = new boolean[map[i].length];
		}
		dfs(0, 0, list);
		System.out.println(ans);
	}
	private static void dfs(int cnt, int scores, Holes[] list) {
		if(cnt == 10 ) {
			ans = Math.max(ans, scores);
			return;
		}	
		for(int i = 0; i < 4 ; i++) {
			if(map[list[i].r][list[i].c] == -1)//이미 도착한 말
				continue;
			int originR = list[i].r;
			int originC = list[i].c;
			int nextC = list[i].c + order[cnt];
			int nextR = list[i].r;
			//파란색 화살표 처리 - 행 바꾸기
			if(nextR == 0 && nextC % 5 == 0 && nextC < 20) {//5, 10, 15번째
				nextR = nextC / 5;
				nextC = 0;
			}
			//주사위 수 보다 도착칸을 넘어섬
			if(nextC >= map[nextR].length) {
				if(nextR == 0 || nextR == 4)
					nextC = map[list[i].r].length-1;
				else { //1,2,3행 -> 4행
					nextR = 4;
					int idx = nextC - map[originR].length;
					if(idx >= map[4].length)
						nextC = map[4].length-1;
					else
						nextC = idx;
				}
			}

			//도착위치가 아니고 말이 가려는 해당위치에 다른 말 있다면 continue
			if(map[nextR][nextC] != -1 ) {
				if(map[nextR][nextC] == 40) { //40은 겹쳐
					if(visit[0][20] || visit[4][3])
						continue;
				}else {
					if(visit[nextR][nextC])
						continue;
				}
			}
			list[i].r = nextR;
			list[i].c = nextC;
			visit[originR][originC] = false; //원래 자리 false
			visit[nextR][nextC] = true;
			int score = map[nextR][nextC]; //점수 더해주기. 도착칸 -1은 하면 안돼.
			if(score != -1) {
				score = map[nextR][nextC];
				dfs(cnt+1, scores+score, list);
			}else {//도착한 말
				dfs(cnt+1, scores, list);
			}
			//원상복귀
			visit[list[i].r][list[i].c] = false;
			visit[originR][originC] = true; //원래자리 true
			list[i].r = originR;
			list[i].c = originC;
		}
		
	}
}
