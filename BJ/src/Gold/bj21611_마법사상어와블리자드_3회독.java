package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj21611_마법사상어와블리자드_3회독 {

	static int N, M, map[][], dir, s, ans[];
	static int dr[] = {0, -1, 1, 0, 0};
	static int dc[] = {0, 0, 0, -1, 1};
	static int ddr[] = {0, 1, 0, -1};
	static int ddc[] = {-1, 0, 1, 0};
	static List<Integer> list;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = new int[4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			dir = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			flag = true;
			//1.구슬 파괴 
			destroy();
			//2.구슬 리스트 만들어
			make();
			//3.폭발있을때 까지 반복 - 구슬 세
			while(flag && list.size() > 0)
				pop();
			//4.구슬 리스트로 새로운 그룹만들어
			//5.map에 세팅
			if(list.size() > 0) {
				group();
				set();
			}
	
		}
		//정답
		System.out.println(ans[1] + (2 * ans[2]) + (3 * ans[3]));
	}
	private static void set() {
		map = new int[N][N];
		int r = N/2;
		int c = N/2;
		int even = 1;
		int odd = 1;
		int d = 0;
		int idx = 0;
		out: while(true) {
			int max = 0;
			if(d % 2 == 0) {
				max = even;
				even++;
			}else {
				max = odd;
				odd++;
			}
			for (int i = 0; i < max; i++) {
				r += ddr[d];
				c += ddc[d];
				map[r][c] = list.get(idx);
				idx++;
				if((r == 0 && c == 0) || idx == list.size())
					break out;
			}
			d = (d+1)%4;
		}	
	}
	private static void group() {
		List<Integer> newList = new ArrayList<>();
		int num = list.get(0);
		int cnt = 1;
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i) == num) {
				cnt++;
			}else {
				newList.add(cnt);
				newList.add(num);
				cnt = 1;
				num = list.get(i);
			}
		}
		newList.add(cnt);
		newList.add(num);
		list = newList;
	}
	private static void pop() {
		List<Integer> newList = new ArrayList<>();
		boolean check = false;
		//4개 연속
		int num = list.get(0);
		int cnt = 1;
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i) == num) {
				cnt++;
			}else {
				if(cnt < 4) {
					for(int j = 0; j < cnt; j++)
						newList.add(num);
				}
					
				else {
					ans[num] += cnt;
					check = true;
				}
				cnt = 1;
				num = list.get(i);
			}
		}
		//마지막 숫자 처리
		if(cnt < 4) {
			for(int j = 0; j < cnt; j++)
				newList.add(num);
		}else {
			ans[num] += cnt;
			check = true;
		}
		
		if(!check) {
			flag = false;
			return;
		}
		list = newList;
	}
	private static void make() {
		list = new ArrayList<>();
		int r = N/2;
		int c = N/2;
		int even = 1;
		int odd = 1;
		int d = 0;
		out: while(true) {
			int max = 0;
			if(d % 2 == 0) {
				max = even;
				even++;
			}else {
				max = odd;
				odd++;
			}
			for (int i = 0; i < max; i++) {
				r += ddr[d];
				c += ddc[d];
				if(map[r][c] != 0)
					list.add(map[r][c]);
				if(r == 0 && c == 0)
					break out;
			}
			d = (d+1)%4;
		}	
	}
	private static void destroy() {
		int r = N/2;
		int c = N/2;
		for (int i = 0; i < s; i++) {
			r += dr[dir];
			c += dc[dir];
			if(r < 0 || c < 0 || r >= N || c >= N )
				break;
			map[r][c] = 0;		
		}
	}
}
