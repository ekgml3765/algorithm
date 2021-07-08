package Level2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 프렌즈4블록 {

	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
		String[] board2 = { "baab", "baab" };
		String[] board3 = { "IIIIOO", "IIIOOO", "IIIOOI", "IOOIII", "OOOIII", "OOIIII" };
		solution(m, n, board);
	}

	static String[][] map;
	static int r, c;
	static int dr[] = { 0, 1, 1 };
	static int dc[] = { 1, 1, 0 };
	static int ans = 0;
	static boolean flag = true;

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		r = m;
		c = n;
		map = new String[r][];
		for (int i = 0; i < board.length; i++) {
			String[] s = board[i].split("");
			map[i] = s;
		}

		while (flag) {
			check(); // 4칸씩 검사
			down(); // 위에서 아래로 내리기
		}
		System.out.println("정답:" + ans);
		answer = ans;
		return answer;
	}

	private static void down() {
		// 맨 아래 행부터 빈칸 찾아.
		for (int j = 0; j < c; j++) {
			boolean flag = true;
			int br = 0; // 빈칸 행
			int bc = 0; // 빈칸 열
			List<Point> monster = new ArrayList<>();
			for (int i = r - 1; i >= 0; i--) {
				// 첫번째 빈칸 찾아
				if (flag) {
					if (map[i][j].equals("-")) {
						br = i;
						bc = j;
						flag = false;
					}
				} else {// 빈칸 찾았다면
					if (map[i][j].equals("-"))
						continue; // 첫번째 빈칸 찾은 이후 또 빈칸이라면 패스
					else {// 몬스터가 있다면
						monster.add(new Point(i, j));
					}
				}
			} // end for
			// 몬스터 내리기
			if (monster.size() != 0) {
				for (Point point : monster) {
					map[br][bc] = map[point.x][point.y];
					map[point.x][point.y] = "-";
					br--;
				}
			}

		}
	}

	private static void check() {

		HashSet<Point> set = new HashSet<Point>();
		for (int i = 0; i < r - 1; i++) {
			out: for (int j = 0; j < c - 1; j++) {
				List<Point> delList = new ArrayList<>();
				delList.add(new Point(i, j));
				String word = map[i][j];
				if (word.equals("-"))
					continue;
				for (int d = 0; d < 3; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (!word.equals(map[nr][nc]))
						continue out;
					delList.add(new Point(nr, nc));
				}
				// 지워야할 애들
				for (Point point : delList) {
					set.add(point);
				}
			}
		}

		if (set.size() == 0) {
			flag = false;
			return;
		}

		// 지워질 것들 지우기
		for (Point point : set) {
			int r = point.x;
			int c = point.y;
			map[r][c] = "-";
		}

		ans += set.size();
	}
}
