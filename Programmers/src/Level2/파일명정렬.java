package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 파일명정렬 {

	public static void main(String[] args) {
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};		
		solution(files2);
	}
	
	
	static class Node implements Comparable<Node>{
		String fileName;
		String head;
		int num;
		String tail;
		int idx;
		public Node(String fileName, String head, int num, String tail, int idx) {
			this.fileName = fileName;
			this.head = head;
			this.num = num;
			this.tail = tail;
			this.idx = idx;
		}
		
		
		@Override
		public int compareTo(Node o) {
			if(this.head.compareTo(o.head) == 0) {//헤드가 같으면
				if(this.num - o.num == 0) {//숫자가 같으면 먼저 들어온 순
					return this.idx - o.idx;
				}
				return this.num - o.num;
			}
			return this.head.compareTo(o.head);
		}	
	}
	 public static String[] solution(String[] files) {
	        String[] answer = {};
	        List<Node> ans = new ArrayList<Node>();
	        String numbers = "0123456789";
	        
	        //헤드, 숫자, 테일로 문자 자르기
	        for (int i = 0; i < files.length; i++) {
				String fileName = files[i];
				String s = files[i].toUpperCase();
				String head = "";
				String tail = "";
				String num = "";
				String[] arr = s.split("");
				boolean headFlag = false;
				boolean tailFlag = false;
				for (int j = 0; j < arr.length; j++) {
					if(!tailFlag && numbers.contains(arr[j])) {//숫자면
						num+=arr[j];
						headFlag = true;
						continue;
					}else {
						//숫자가 아니면
						if(!headFlag)
							head += arr[j];
						else {
							tail += arr[j];
							tailFlag = true;
						}			
					}
				}
				ans.add(new Node(fileName, head, Integer.parseInt(num), tail, i));
			}
	        
	        Collections.sort(ans);
	        answer = new String[ans.size()];
	        for (int i = 0; i < ans.size(); i++) {
				answer[i] = ans.get(i).fileName;
			}
	        return answer;
	    }
}
