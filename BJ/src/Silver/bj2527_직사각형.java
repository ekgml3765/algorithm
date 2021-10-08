package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2527_직사각형 {
	static class square {
		int x1, y1, x2, y2;

		public square(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 4; tc++) {
			char ans = 'a';
			StringTokenizer st = new StringTokenizer(in.readLine());
			square A = new square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			square B = new square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if ((A.x2 == B.x1 && A.y2 == B.y1) || (A.x1 == B.x2 && A.y2 == B.y1) || (A.x1 == B.x2 && A.y1 == B.y2)
					|| (A.x2 == B.x1  && A.y1 == B.y2))
				ans = 'c';
			if ((A.y2 == B.y1 && A.x1 < B.x2 && B.x1 < A.x2) || (A.y1 == B.y2 && A.x1 < B.x2 && B.x1 < A.x2)
					|| (A.x1 == B.x2 && B.y1 < A.y2 && A.y1 < B.y2) || (A.x2 == B.x1 && B.y1 < A.y2 && A.y1 < B.y2))
				ans = 'b';
			if ((A.x2 < B.x1) || (B.x2 < A.x1) || (A.y2 < B.y1) || (B.y2 < A.y1))
				ans = 'd';
			System.out.println(ans);
		}
	}
}
