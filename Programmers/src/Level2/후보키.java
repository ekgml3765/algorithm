package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 후보키 {

	public static void main(String[] args) {
		String[][] relation = { { "100", "100", "ryan", "music", "2" },
				{ "200", "200", "apeach", "math", "2" },
				{ "300", "300", "tube", "computer", "3" },
				{ "400", "400", "con", "computer", "4" },
				{ "500", "500", "muzi", "music", "3" },
				{ "600", "600", "apeach", "music", "2" } };
//		String[][] relation = { { "100", "ryan", "music", "2" },
//				{ "200", "apeach", "math", "2" },
//				{ "300",  "tube", "computer", "3" },
//				{ "400",  "con", "computer", "4" },
//				{ "500", "muzi", "music", "3" },
//				{ "600", "apeach", "music", "2" } };
		
		String[][] rel = {{"a","1","aaa","c","ng"},{"b","1","bbb","c","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}};
		solution(rel);
	}

	static Integer[] sel;
	static int ans;
	static List<List<Integer>> list;
	private static void comb(int idx, int s_idx, int cnt, int maxCnt, String[][] relation) {
		if(s_idx == cnt) {//cnt 컬럼수 만큼 조합
			//해당 조합으로 유일성 체크
			HashSet<String> set = new HashSet<String>();
			for (int i = 0; i < relation.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < sel.length; j++) {
					sb.append(relation[i][sel[j]]);
					
				}
				set.add(sb.toString());
			}
			
			//최소성 체크
			if(set.size() == relation.length) {
				//해당 컬럼 조합이 이미 있는지 체크하기
				List<Integer> ckey = new ArrayList<>(Arrays.asList(sel));
				boolean flag = true;
				for (int i = 0; i < list.size(); i++) {
					//최소성 만족x
					if(ckey.containsAll(list.get(i))) {
						flag = false; 
						break;
					} 		
				}
				if(flag) {
					list.add(ckey);
					ans++;
				}
			}
			
			return;
		}
		if(idx == maxCnt) {
			return;
		}
		
		sel[s_idx] = idx;
		comb(idx+1, s_idx+1, cnt, maxCnt, relation);
		comb(idx+1, s_idx, cnt, maxCnt, relation);
	}
	
	public static int solution(String[][] relation) {
		int answer = 0;
		ans = 0;
		list = new ArrayList<>(); //후보키 리스트
		//컬럼 갯수 만큼 조합을 만들어서 유일성을 체크.
		for (int i = 0; i < relation[0].length; i++) { 
			int cnt = i+1; //선택할 튜플 갯수
			sel = new Integer[cnt];
			comb(0, 0, cnt, relation[0].length, relation);
		}
		answer = ans;
		System.out.println("정답"+ " " + answer);
		return answer;
	}
}
