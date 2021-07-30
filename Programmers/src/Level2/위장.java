package Level2;

import java.util.HashMap;

public class 위장 {

	public static void main(String[] args) {
		String[][] clothes = {
				{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}
		};
		solution(clothes);
	}


	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
		}
		for (String key : map.keySet()) {
			answer*= map.get(key)+1; //경우의 수
		}
		answer--; // 무조건 한개의 의상은 입으므로 다 안입을 경우 뺌
		return answer;
	}
		
}
