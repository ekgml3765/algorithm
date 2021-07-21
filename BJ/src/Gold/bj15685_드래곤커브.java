package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj15685_드래곤커브 {

	static class Dragon{
		int x, y, d, g;

		public Dragon(int x, int y, int d, int g) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}		
	}
	static int map[][];
	static int ans = 0;
	static Dragon[] dragonList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		dragonList = new Dragon[N];
		map = new int [101][101];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragonList[i] = new Dragon(x, y, d, g);
		}//입력 끝
		dragon();
		count();
		System.out.println(ans);
	}
	
	//드래곤 커브 그리기
	static int dr[] = {0, -1, 0, 1};
	static int dc[] = {1, 0, -1, 0};
	private static void dragon() {
		for (int i = 0; i < dragonList.length; i++) {
			Dragon dragon = dragonList[i];
			//0세대 
			map[dragon.y][dragon.x] = 1;
			int endR = dragon.y + dr[dragon.d];
			int endC = dragon.x + dc[dragon.d];
			map[endR][endC] = 1;
			int g = dragon.g; //g세대
			List<Integer> dirInfo = new ArrayList<Integer>();
			dirInfo.add(dragon.d);
			for (int j = 1; j <= g; j++) { // 1세대~g세대까지
				Integer check[] = dirInfo.toArray(new Integer[dirInfo.size()]);
				for (int l = check.length-1; l >= 0; l--) {
					int currDir = dirInfo.get(l);
					int nextDir = (currDir+1) % 4;
					int nr = endR + dr[nextDir];
					int nc = endC + dc[nextDir];
					map[nr][nc] = 1;
					endR = nr;
					endC = nc;
					dirInfo.add(nextDir);
				}
			} //end for		
		}
	}

	//정사각형 갯수 세기
	static int dir[][] = {{0,1},{1,0},{1,1}};
	private static void count() {
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j] == 1) {
					int cnt = 1;
					for (int d = 0; d < 3; d++) {
						int nr = i + dir[d][0];
						int nc = j + dir[d][1];
						if(nr >= 0 && nc >= 0 && nr < 101 && nc < 101 && map[nr][nc] == 1)
							cnt++;
					}
					if(cnt == 4)
						ans++;
				}
			}
		}
	}
}
