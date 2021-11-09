package Silver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class bj1342_행운의문자열 {
	static Character arr[], sel[];
	static int alph[], size, ans = 0;
	static boolean check[];
	static HashSet<Character> set = new HashSet<Character>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		size = s.length();
		alph = new int[26];
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			set.add(c);
			alph[c-97]++;
		}
		arr = set.toArray(new Character[set.size()]);
		sel = new Character[size];
		perm(0);
		System.out.println(ans);
	}
	static public void perm(int idx) {
		if(idx == size) {
			ans++;
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			if(alph[arr[i]-97] > 0) {
				if(idx > 0 && sel[idx-1]== arr[i])
					continue;
				alph[arr[i]-97]--;
				sel[idx] = arr[i];
				perm(idx+1);
				alph[arr[i]-97]++;
			}
		}
	}
}
