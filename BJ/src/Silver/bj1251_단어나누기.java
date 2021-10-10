package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj1251_단어나누기 {

	static int sel[], size;
	static List<String> list;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		s = in.readLine();
		size = s.length();
		sel = new int[2];
		list = new ArrayList<String>();
		comb(1, 0);
		Collections.sort(list);
		System.out.println(list.get(0));
	}

	private static void comb(int idx, int s_idx) {
		if(s_idx == 2) {
			StringBuilder sb1 = new StringBuilder(s.substring(0, sel[0])); 
			StringBuilder sb2 = new StringBuilder(s.substring(sel[0], sel[1]));
			StringBuilder sb3 = new StringBuilder(s.substring(sel[1], s.length()));
			sb1.reverse();
			sb2.reverse();
			sb3.reverse();
			list.add(sb1.toString()+sb2.toString()+sb3.toString());
			return;
		}
		if(idx == size)
			return;
		sel[s_idx] = idx;
		comb(idx+1, s_idx+1);
		comb(idx+1, s_idx);
		
	}
}
