package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj10816_숫자카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int arr[] = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			int ans = 0;
			int num = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = arr.length-1;
			int mid = 0;
			while(start<=end) {
				mid = (start+end) / 2;
				if(arr[mid] == num) {
					ans = map.get(num);
					break;
				}
				if(arr[mid] < num) {
					start = mid+1;
				}
				if(arr[mid] > num) {
					end = mid-1;
				}
			}
			sb.append(ans + " ");
		}
		System.out.println(sb.toString());
	}
}
