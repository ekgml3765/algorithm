

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj1654_랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		Integer arr[] = new Integer [K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr,Collections.reverseOrder());
		
		int start = 0;
		int end = arr[0];
		int mid = end/2;

		int r_cnt;
		if(mid==0) {
			System.out.println(1);
		}else {
			while(true) {
				r_cnt = 0;
				for (int i = 0; i < K; i++) {
					r_cnt += arr[i]/mid;
				}
				
				if(r_cnt < N) {//더 작은 단위로 나눠져야함 -> 왼쪽
					end = mid;
				}else if(r_cnt >= N) {//오른쪽 
					start = mid;
				}
				mid = ((end-start)/2) + start;
				if(mid == start) break;
			}
		
			r_cnt=0;
			for (int i = 0; i < K; i++) {
				r_cnt += arr[i]/end;
			}
			
			int ans = (r_cnt==N) ? end:start;
			System.out.println(ans);
		}
		
		
	
	}
}
