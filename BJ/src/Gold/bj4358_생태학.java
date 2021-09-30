package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class bj4358_생태학 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		while(true) {
			String s = in.readLine();
			if(s==null)
				break;
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		double sum = 0;
		List<String> list = new ArrayList<>();
		for (String key : map.keySet()) {
			sum += map.get(key);
			list.add(key);
		}
		Collections.sort(list);
		for (String key : list) {
			System.out.println(key + " " + String.format("%.4f", (double) (map.get(key)/sum)*100));
		}
	}	
}
