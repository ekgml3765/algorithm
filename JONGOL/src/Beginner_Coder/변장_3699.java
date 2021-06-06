package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 변장_3699 {

	static ArrayList<Integer> items;
	static int sel[];
	static int ans = 0;


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine()); //테스트케이스 입력
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine()); // 의상 수 입력
			if(N == 0 ) {
				System.out.println(0); continue;
			}
			String cloth[] = new String [N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				st.nextToken();
				cloth[i] = st.nextToken(); //종류만 담음
			}
			//오름차순
			Arrays.sort(cloth);
			items = new ArrayList<Integer>();
			int idx = 0, cnt = 1; 
			for (int i = 1; i < N; i++) {
				if(cloth[idx].equals(cloth[i])) {
					cnt++;
					continue;
				}
				// 의상종류가 다르면 
				items.add(cnt);
				idx = i;
				cnt = 1;
			}			
			items.add(cnt);					
			//System.out.println(items);
			
			ans = 0;
			//총 종류 수만큼 뽑을때
			for (int i = 1; i <= items.size(); i++) {
				sel = new int[i];
				comb(0, 0);
			}
			System.out.println(ans);
		}
	
	}

	private static void comb(int idx, int s_idx) {

		if (s_idx == sel.length) {
			//System.out.println(Arrays.toString(sel));
			int sum = 1;	
				for (int i = 0; i < sel.length; i++) {
					sum *= items.get(sel[i]);
				}	
			
			//System.out.println(sum);
			ans += sum;
			return;
		}
		if (idx == items.size()) {
			return;
		}

		sel[s_idx] = idx;
		comb(idx + 1, s_idx + 1);
		comb(idx + 1, s_idx);

	}
}
