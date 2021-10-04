package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class swea_5658_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String arr[] = in.readLine().split("");
			TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
			for(int i = 0; i < N/4; i++) {
				String tmp = arr[N-1];
				for (int j = N-1; j > 0; j--) {
					arr[j] = arr[j-1];
				}
				arr[0] = tmp;
				for (int j = 0; j < arr.length; j+= N/4) {
					StringBuilder sb = new StringBuilder();
					for (int k = j; k < j+(N/4); k++) {
						sb.append(arr[k]);
					}
					set.add(sb.toString());
				}
			}
			String answer[] = set.toArray(new String[set.size()]);
			System.out.println("#" + tc + " " + Long.parseLong(answer[K-1], 16));
		}
		
	}
}
