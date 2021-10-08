package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj1920_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		Arrays.sort(arr);
		for (int i = 0; i < M; i++) {
			int ans = 0;
			int key = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = arr.length-1;
			while(start <= end) {
				int mid = (start+end)/2;
				if(arr[mid] == key) {
					ans = 1;
					break;
				}
				if(arr[mid] < key) {
					start = mid + 1;
				}
				if(arr[mid] > key) {
					end = mid -1;
				}		
			}
			System.out.println(ans);
		}
	}
}
