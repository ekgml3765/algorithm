package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2531_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int	d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int kind[] = new int[d+1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		int ans = 0;
		int cnt = 0;
		int start = 0;
		int end = 0;
		while(start < N) {
			if(end-start+1 <= k) {
				kind[arr[end % N]]++;
				cnt += (kind[arr[end % N]]==1)? 1 : 0;
				end++;
				if(kind[c] == 0)
					ans = Math.max(cnt+1, ans);
				else
					ans = Math.max(cnt, ans);
			}else {
				kind[arr[start]]--;
				cnt -= (kind[arr[start]]==0)? 1 : 0;
				start++;
			}	
		}
		System.out.println(ans);
	}
}
