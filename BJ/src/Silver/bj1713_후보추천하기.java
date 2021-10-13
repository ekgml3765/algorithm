package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class bj1713_후보추천하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int arr[] = new int[M];
		List<Integer> pic = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			map.put(arr[i], 0);
		}
		for (int i = 0; i < arr.length; i++) {
			if (pic.contains(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
				continue;
			}
			if (pic.size() < N) {
				pic.add(arr[i]);
				map.put(arr[i], map.get(arr[i]) + 1);

			} else {
				int idx = 0;
				int min = map.get(pic.get(0));
				for (int j = 0; j < pic.size(); j++) {
					if (map.get(pic.get(j)) < min) {
						idx = j;
						min = map.get(pic.get(j));
					}
				}
				map.put(pic.get(idx), 0);
				pic.remove(idx);
				pic.add(arr[i]);
				map.put(arr[i], map.get(arr[i]) + 1);

			}
		}
		Collections.sort(pic);
		for (int i = 0; i < pic.size(); i++) {
			System.out.print(pic.get(i) + " ");
		}
	}
}
