package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 튜플 {
	public static int[] solution(String s) {
        s = s.substring(1, s.length());
        StringTokenizer st = new StringTokenizer(s, "{}");
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(st.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ",");
            while(st2.hasMoreTokens()) {
                int num = Integer.parseInt(st2.nextToken());
                map.put(num, map.getOrDefault(num, 0)+1);
            }
        }
        int size = map.size();
        int ans [] = new int[size];
        for (Integer key :  map.keySet()) {
			ans[size-map.get(key)] = key;
		}
        return ans;
    }
}
