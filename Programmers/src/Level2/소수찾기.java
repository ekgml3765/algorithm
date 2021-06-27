package Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String numbers = in.readLine();
		solution(numbers);
	}

	static int array[];
	static int r;
	static int sel[];
	static boolean check[];
	static int cnt = 0;
	static boolean numberCheck[] = new boolean [10000000];
	static public int solution(String numbers) {
		int answer = 0;
		int arr[] = new int[numbers.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = numbers.charAt(i) - '0';
		}
		array = arr;
		for (int i = 1; i <= arr.length; i++) {
			r = i;
			sel = new int[r];
			check = new boolean[arr.length];
			perm(0);
		}
		answer = cnt;
		return answer;
	}

	private static void perm(int idx) {
		
		if(idx == r) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < sel.length; i++) {
				if(sel[0] == 0)
					return;
				sb.append(sel[i]);
			}
			int num = Integer.parseInt(sb.toString());
			//이미 검사한 소수 인지 아닌지 체크
			if(!numberCheck[num]) {
				//소수처리
				if(checking(num))
					cnt++;
				numberCheck[num] = true;
			}
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			if(!check[i]) {
				check[i] = true;
				sel[idx] = array[i];
				perm(idx+1);
				check[i] = false;
			}
		}
	}

	//소수인지 아닌지 체크
	private static boolean checking(int num) {
		if(num < 2) {
			return false;
		}
		for (int i = 2; i <= num / i; i++) {
			if(num % i == 0) 
				return false;				
		}
		return true;
	}
}
