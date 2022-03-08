package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1091_카드섞기 {

	static int N, P[], S[], ans = -1, cnt = 0, arr[], origin[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		P = new int[N];
		S = new int[N];
		arr = new int[N];
		origin = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
			arr[i] = i;
			origin[i] = i;
		}
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
	
		while(true) {
			boolean flag = true;
			boolean out = true;
			for(int i = 0; i < N; i++) {
				if(P[arr[i]] != i%3) {
					flag = false;
				}
				if(arr[i] != origin[i]) {
					out = false;
				}
			}
			if(flag) {
				ans = cnt;
				break;
			}
			if(out && cnt > 1) {
				break;
			}
			//섞어
			int comp[] = arr.clone();
			for(int i = 0; i < N; i++) {
				arr[S[i]] = comp[i];
			}
			cnt++;
		}
		System.out.println(ans);
	}
}
