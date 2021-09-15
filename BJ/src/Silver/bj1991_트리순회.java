package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj1991_트리순회 {
	static int N, arr[][];
	static String s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			char s[] = in.readLine().replaceAll(" ", "").toCharArray();
			arr[s[0]-65][0] = (s[1]=='.')? -1: s[1]-65;
			arr[s[0]-65][1] = (s[2]=='.')? -1: s[2]-65;
		}
		s = "A";
		preorder(0);
		System.out.println(s);
		s = "";
		inorder(0);
		System.out.println(s);
		s = "";
		postorder(0);
		System.out.println(s);
	}
	private static void preorder(int r) {
		for (int i = 0; i < 2; i++) {
			if(arr[r][i] != -1) {
				s += (char)(arr[r][i]+65);
				preorder(arr[r][i]);
			}
		}
	}
	private static void inorder(int r) {
		for (int i = 0; i < 2; i++) {
			if(arr[r][i] != -1) {
				inorder(arr[r][i]);
			}
			if(i != 1)
				s += (char)(r+65);
		}
	}
	private static void postorder(int r) {
		for (int i = 0; i < 2; i++) {
			if(arr[r][i] != -1) {
				postorder(arr[r][i]);
			}
		}
		s += (char)(r+65);
	}
}
