package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20061_모노미노도미노2 {

	static int N, score = 0, cnt=0;
	static int info[][];
	static int green[][], blue[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		info = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			info[i][0] = Integer.parseInt(st.nextToken()); //t
			info[i][1] = Integer.parseInt(st.nextToken()); //x
			info[i][2] = Integer.parseInt(st.nextToken()); //y
		}
		green = new int[6][4];
		blue = new int[4][6];	
		for (int i = 0; i < N; i++) {
			int t = info[i][0];
			int x = info[i][1];
			int y = info[i][2];
			down(t, x, y); //도형 떨구기
			full();//가득차 있는지 체크
			check();//특별한칸 체크
		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if(green[i][j]==1)
					cnt++;
				if(blue[j][i] == 1)
					cnt++;
			}
		}
		System.out.println(score);
		System.out.println(cnt);
	}
	private static void check() {
		int greenCnt = 0;
		int blueCnt = 0;
		for (int i = 0; i < 2; i++) {
			if(green[i][0] == 1 || green[i][1] == 1 || green[i][2] == 1 || green[i][3] == 1)
				greenCnt++;
			if(blue[0][i] == 1 || blue[1][i] == 1 || blue[2][i] == 1 || blue[3][i] == 1)
				blueCnt++;
		}
		//그린
		for (int i = 0; i < greenCnt; i++) {
			move(5, 1);
		}
		//블루
		for (int i = 0; i < blueCnt; i++) {	
			move(5, 2);
		}		
	}
	private static void full() {		
		//그린
		for (int i = 5; i >= 0; i--) {
			if(green[i][0] == 1 && green[i][1] == 1 && green[i][2] == 1 && green[i][3] == 1) {
				score++;
				move(i,1);
				i++;
			}
		}
		//블루
		for (int j = 5; j >= 0; j--) {
			if(blue[0][j] == 1 && blue[1][j] == 1 &&blue[2][j] == 1 &&blue[3][j] == 1) {
				score++;
				move(j, 2);
				j++;
			}
		}
	}
	
	private static void move(int k , int color) {
		if(color == 1) { //그린
			for (int j = 0; j < 4; j++) {
				for (int i = k; i > 0; i--) {
					green[i][j] = green[i-1][j];
				}
				green[0][j] = 0;
			}
		}else {//블루
			for (int i = 0; i < 4; i++) {
				for (int j = k; j > 0; j--) {
					blue[i][j] = blue[i][j-1];
				}
				blue[i][0] = 0;
			}
		}		
	}
	
	private static void down(int t, int x, int y) {
		int locGreen = -1;
		int locBlue = -1;
		if(t==1) {
			for (int i = 0; i < 6; i++) {
				if(green[i][y] == 1)
					break;
				locGreen++;
			}
			green[locGreen][y] = 1;
			
			for (int j = 0; j < 6; j++) {
				if(blue[x][j] == 1)
					break;
				locBlue++;
			}
			blue[x][locBlue] = 1;
		}
		if(t==2) {		
			for (int i = 0; i < 6; i++) {
				if(green[i][y] == 1 || green[i][y+1] == 1)
					break;
				locGreen++;
			}
			green[locGreen][y] = 1;
			green[locGreen][y+1] = 1;
			
			locBlue = 0;
			for (int j = 1; j < 6; j++) {
				if(blue[x][j-1] == 1 || blue[x][j] == 1)
					break;
				locBlue++;
			}
			blue[x][locBlue-1] = 1;
			blue[x][locBlue] = 1;
		}
		if(t==3) {
			locGreen = 0;
			for (int i = 1; i < 6; i++) {
				if(green[i-1][y] == 1 || green[i][y] == 1)
					break;
				locGreen++;
			}
			green[locGreen-1][y] = 1;
			green[locGreen][y] = 1;
			
			for (int j = 0; j < 6; j++) {
				if(blue[x][j] == 1 || blue[x+1][j] ==1)
					break;
				locBlue++;
			}
			blue[x][locBlue] = 1;
			blue[x+1][locBlue] = 1;		
		}	
	}
}
