package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 메뉴리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		solution(orders, course);
	}
	
	static int r;
	static char[] sel;
	static List<String> selList;
	static int max;
	//알파벳 조합
	public static void comb(int idx, int s_idx, String[] orders) {
		
		if(s_idx == r) {
			int cnt = 0;
			out: for (int i = 0; i < orders.length; i++) {
				for (int j = 0; j < sel.length; j++) {
					if(!orders[i].contains(Character.toString(sel[j])))
						continue out;
				}
				cnt++;
			}
			if(cnt > max) {
				max = cnt;
				selList.clear();
				if(cnt>=2)
					selList.add(new String(sel));
				
			}
			else if(cnt >=2 && cnt == max ) {
				selList.add(new String(sel));
			}
			return;
		}
		if(idx == 26) {
			return;
		}
		
		sel[s_idx] = (char)(idx+65);
		comb(idx+1, s_idx+1, orders);
		comb(idx+1, s_idx, orders);
		
	}
	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		selList = new ArrayList<String>();
		List<String> ans = new ArrayList<String>();
	
		for (int i = 0; i < course.length; i++) {
			int number = course[i];
			//갯수대로 알파벳 26에 대한 조합
			r = number;
			sel = new char[r];
			max = 0;
			comb(0,0, orders);
			//System.out.println(max);
			//list 추출
			for (int j = 0; j < selList.size(); j++) {
				ans.add(selList.get(j));
			}
		}
		//오름차순 정렬
		Collections.sort(ans);
		//리스트 -> 배열
		answer = ans.toArray(new String[ans.size()]);
		return answer;
	}
}
