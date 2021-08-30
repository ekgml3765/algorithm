package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 순위검색 {
	static HashMap<String, List<Integer>> map;

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		map = new HashMap<String, List<Integer>>();
		for (int i = 0; i < info.length; i++) {
			powerSet(0, "", info[i].split(" "));
		}
		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
		for (int i = 0; i < query.length; i++) {
			String arr[] = query[i].split(" and | ");
			String key = String.join("", arr[0], arr[1], arr[2], arr[3]);
			List<Integer> list = map.getOrDefault(key, new ArrayList<Integer>());
			// Collections.sort(list);
			int score = Integer.parseInt(arr[4]);
			int start = 0;
			int end = list.size();
			while (start < end) {
				int mid = (start + end) / 2;
				if (list.get(mid) < score)
					start = mid + 1;
				else
					end = mid;
			}
			answer[i] = list.size() - start;
		}
		return answer;
	}

	private static void powerSet(int idx, String s, String arr[]) {
		if (idx == 4) {
			map.computeIfAbsent(s, k -> new ArrayList<Integer>()).add(Integer.parseInt(arr[4]));
			return;
		}
		powerSet(idx + 1, s + arr[idx], arr);
		powerSet(idx + 1, s + "-", arr);
	}
}
