package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20055_컨베이어벨트위의로봇 {

	static int N, K, map[], robot[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()) * 2;
		K = Integer.parseInt(st.nextToken());
		map = new int[N];
		robot = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		int time = 1;

		while (true) {		
			rotate();
			move();
			if(map[0] > 0) {
				map[0]--;
				robot[0] = 1;
			}
			if (count())
				break;
			time++;
		}
		System.out.println(time);
	}

	private static void move() {

		for (int i = N / 2 - 2; i >= 0; i--) {
			if(robot[i]==1) {
				if(map[i+1] > 0 && robot[i+1] != 1) {
					map[i+1]--;
					robot[i+1] = 1;
					robot[i] = 0;
				}
			}
		}
		// 내리는 자리 확인
		if (robot[N / 2 - 1] == 1)
			robot[N / 2 - 1] = 0;
	}

	private static void rotate() {
		int tmp = map[N - 1];
		int tmp2 = robot[N - 1];
		for (int i = N - 1; i > 0; i--) {
			map[i] = map[i - 1];
			robot[i] = robot[i - 1];
		}
		map[0] = tmp;
		robot[0] = tmp2;
		// 내리는 자리 확인
		if (robot[N / 2 - 1] == 1)
			robot[N / 2 - 1] = 0;
	}

	private static boolean count() {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			if (map[i] == 0)
				cnt++;
		}
		if (cnt >= K)
			return true;
		return false;
	}
}
