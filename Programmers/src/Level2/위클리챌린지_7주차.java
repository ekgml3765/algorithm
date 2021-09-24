package Level2;
import java.util.HashMap;
class 위클리챌린지_7주차 {
    public int[] solution(int[] enter, int[] leave) {
		int[] answer = new int[enter.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
		for (int i = 0; i < enter.length; i++) {
			index.put(enter[i], i);
		}
		int idx = 0;
		int i = 0;
		boolean flag = false;
		while (idx < enter.length && i < leave.length) {
			if (!flag)
				map.put(enter[idx], map.size());
			while (map.get(leave[i]) != null) {
				answer[leave[i] - 1] = map.get(leave[i]) + (idx - index.get(leave[i]));
				map.remove(leave[i]);
				i++;
				if (map.size() == 0)
					break;
			}
			if (idx < enter.length - 1)
				idx++;
			else {
				flag = true;
			}
		}
		return answer;
    }
}