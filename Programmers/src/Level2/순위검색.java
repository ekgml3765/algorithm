package Level2;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 순위검색 {

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		solution(info, query);
	}

	static String[][] condition;
	static Node[] user;

	static class Node implements Comparable<Node> {
		String[] info;
		int score;

		public Node(String[] info, int score) {
			this.info = info;
			this.score = score;
		}

		@Override
		public int compareTo(Node o) {
			return this.score - o.score;
		}
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		StringTokenizer st;
		// 지원자 정보
		int InfoSize = info.length;
		user = new Node[InfoSize];
		for (int i = 0; i < InfoSize; i++) {
			st = new StringTokenizer(info[i], " ");
			String[] userInfo = new String[4];
			for (int j = 0; j < 4; j++) {
				userInfo[j] = st.nextToken();
			}
			int score = Integer.parseInt(st.nextToken());
			user[i] = new Node(userInfo, score);
		}

		// 점수로 정렬
		Arrays.sort(user);

		// 점수표 배열로
		condition = new String[query.length][5]; // 조건 이차원 배열
		for (int i = 0; i < query.length; i++) {
			st = new StringTokenizer(query[i], " ");
			int c = 0;
			int size = st.countTokens();
			for (int j = 0; j < size; j++) {
				String s = st.nextToken();
				if (!s.equals("and")) {
					condition[i][c] = s;
					c++;
				}
			}
			
			// 점수 이상인거 이분법으로 나눠서 찾아
			int score = Integer.parseInt(condition[i][4]);
			System.out.println("스코어는" + " "+ score);
			// 조건표대로 고려해서 뽑아. 끝 마지막끝점 그거보다 큰 경우. 그떄는 0
			if( score > user[InfoSize-1].score)
				answer[i] = 0;
			else {
					//이분법
					int startIdx = 0;
					int LastIdx = InfoSize-1;
					int compIdx = (LastIdx+startIdx)/ 2;
					while(LastIdx-startIdx > 1) {
						if(user[compIdx].score >= score) {
							LastIdx = compIdx;
							startIdx = 0;
						}else {
							startIdx++;
						}
						compIdx = (LastIdx+startIdx) / 2;
					}
					System.out.println(user[startIdx].score + " " + user[LastIdx].score);
					//startIdx, LastIdx비교
					if(LastIdx != 0) { //Info가 1이상
						if(user[startIdx].score < score)
							startIdx = LastIdx;
					}
					
					//조건 비교
					int cnt = 0;
					out: for (int j = startIdx; j < user.length; j++) {
						for (int k = 0; k < 4; k++) {
							if( condition[i][k].equals("-")|| user[j].info[k].equals(condition[i][k]))
								continue;
							else
								continue out;
						}
						cnt++;
					}
					answer[i] = cnt;
			}
		} // end for

		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
