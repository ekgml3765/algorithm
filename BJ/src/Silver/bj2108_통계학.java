package Silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bj2108_통계학 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer numbers[] = new Integer[N];
		double sum = 0;
		int count[] = new int[8002];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
			sum += numbers[i];
			if (numbers[i] >= 0) // 0~4000
				count[numbers[i]]++;
			else { // 음수
				count[Math.abs(numbers[i]) + 4000]++;
			}
		}

		List<Integer> list = new ArrayList<>();
		int max = 0;
		int idx = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > max) {
				max = count[i];
				idx = (i > 4000) ? (i * -1) + 4000 : i;
				list.clear();
				list.add(idx);
				continue;
			}
			if (count[i] == max) {
				idx = (i > 4000) ? (i * -1) + 4000 : i;
				list.add(idx);
			}
		}
		Collections.sort(list);
		Arrays.sort(numbers);
		System.out.println(Math.round(sum / N)); // 산술 평균
		System.out.println(numbers[N / 2]); // 중앙값
		System.out.println((list.size() > 1 ? list.get(1) : list.get(0)));// 최빈값
		System.out.println(numbers[N - 1] - numbers[0]); // 범위
	}
}
