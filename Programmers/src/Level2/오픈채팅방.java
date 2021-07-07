package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
	
	 public static String[] solution(String[] record) {
	        String[] answer = {};
	        String [][] arr = new String [record.length][];
	        Map<String, String> map = new HashMap<String, String>();
	        
	        //문자열 배열로 변환, 닉네임 뽑기
	        for (int i = 0; i < record.length; i++) {
				String[] s = record[i].split(" "); 
	        	arr[i] = s;
	        	if(arr[i][0].equals("Enter") || arr[i][0].equals("Change")) {
	        		map.put(s[1], s[2]);
	        	}
			}
	        
	        List<String> ans = new ArrayList<String>();
	        for (int i = 0; i < arr.length; i++) {
	        	if(arr[i][0].equals("Change")) 
	        		continue;
	        	StringBuilder sb = new StringBuilder();
				arr[i][1] = map.get(arr[i][1]);
				sb.append(arr[i][1]);
				if(arr[i][0].equals("Enter")) {
					sb.append("님이 들어왔습니다.");
				}
				if(arr[i][0].equals("Leave")) {
					sb.append("님이 나갔습니다.");
				}
				ans.add(sb.toString());
			}
	      
	        answer = ans.toArray(new String[ans.size()]);
	        return answer;
	    }
}
