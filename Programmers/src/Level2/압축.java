package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 압축 {

	public static void main(String[] args) {
		String msg = "ABABABABABABABAB";
		solution(msg);
	}

	public static int[] solution(String msg) {
		int[] answer = {};
		List<Integer> list = new ArrayList<Integer>();
		String[] arr = msg.split("");
		Queue<String> queue = new LinkedList<String>();
		for (String string : arr) {
			queue.add(string);
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//알파벳 해쉬
		for (int i = 1; i <= 26; i++) {
			char c = (char) (64+i);
			map.put( String.valueOf(c), i);
		}
		
		int idx = 27;
		boolean flag = false;
		String w = "";
		while(true) {
			if(!flag)
				w = queue.poll();
			String c = queue.peek();
			String wc = w+c;
			if(c == null) {//널처리
				list.add(map.get(w));
				break;
			}
			
			if(map.get(wc)!=null) {//사전에 있어
				w = wc;
				queue.poll();
				flag = true;
				
			}else {//사전에 없어
				list.add(map.get(w));
				//사전에 추가
				map.put(wc, idx);
				idx++;
				flag = false;
			}	
		}
		
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}

}
