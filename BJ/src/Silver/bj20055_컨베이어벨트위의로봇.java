package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class bj20055_컨베이어벨트위의로봇 {

	static int N, K, stage;
	static class Node {
		int A;
		boolean isRobot;

		public Node(int a, boolean isRobot) {
			A = a;
			this.isRobot = isRobot;
		}
	}

	static List<Integer> robotList;
	static Node[] belt;
	static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		stage = 1;
		robotList = new ArrayList<Integer>();
		belt = new Node[N * 2];
		size = N * 2;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N * 2; i++) {
			belt[i] = new Node(Integer.parseInt(st.nextToken()), false);
		}

		while (true) {
			rotation(); // 벨트와 로봇 함께 한칸 회전
			move(); // 로봇 이동
			if (belt[0].A > 0) { // 올리는 위치에 로봇 올리기
				belt[0].isRobot = true;
				belt[0].A--;
			}
			int cnt = count();
			if (cnt >= K) { // 내구도가 0인 칸의 개수가 k개 이상이라면 과정 종료
				System.out.println(stage);
				return;
			}
			stage++;
		}
	}

	private static int count() {
		int cnt = 0;
		for (int i = 0; i < belt.length; i++) {
			if (belt[i].A == 0)
				cnt++;
		}
		return cnt;
	}

	// 로봇이동
	private static void move() {
		// 로봇 먼저 이동 -> 이동하려는 자리가 N-1번째라면 로봇 내려.
		for (int i = 0; i < robotList.size(); i++) {
			int curr = robotList.get(i); // 로봇 위치
			int next = (curr + 1) % size; // 새롭게 이동할 위치
			if (!belt[next].isRobot && belt[next].A > 0) { // 이동가능
				belt[curr].isRobot = false;
				belt[next].isRobot = true;
				belt[next].A--;
				if (next == N - 1) {// 내려가는 자리
					belt[next].isRobot = false;
				}
			}
		}
	}

	// 함께 회전
	private static void rotation() {
		int A = belt[size-1].A;
		boolean isRobot = belt[size-1].isRobot;
		for (int i = size - 1; i > 0; i--) {
			belt[i].A = belt[i - 1].A;
			belt[i].isRobot = belt[i-1].isRobot;
		}
		belt[0].A = A;
		belt[0].isRobot = isRobot;
		if (belt[N - 1].isRobot) // 해당 로봇 내림
			belt[N - 1].isRobot = false;
		robotList = new ArrayList<>();
		for (int i = N-1; i > 0; i--) { //로봇 순서대로
			if (belt[i].isRobot) 
				robotList.add(i);
		}
	}
}
