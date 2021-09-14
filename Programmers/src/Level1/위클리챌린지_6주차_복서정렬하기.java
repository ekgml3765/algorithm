package Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 위클리챌린지_6주차_복서정렬하기 {

	static class boxer implements Comparable<boxer> {
		int num, cnt, weight;
		double rate;

		public boxer(int num, double rate, int cnt, int weight) {
			this.num = num;
			this.rate = rate;
			this.cnt = cnt;
			this.weight = weight;
		}

		@Override
		public int compareTo(boxer o) {
			if (Double.compare(o.rate, this.rate) == 0) {
				if (o.cnt == this.cnt) {
					if (o.weight == this.weight)
						return this.weight - o.weight;
					return o.weight - this.weight;
				}
				return o.cnt - this.cnt;
			}
			return Double.compare(o.rate, this.rate);
		}
	}

	public int[] solution(int[] weights, String[] head2head) {
		int[] answer = new int[weights.length];
		List<boxer> list = new ArrayList<>();
		for (int i = 0; i < weights.length; i++) {
			String arr[] = head2head[i].split("");
			double sum = 0;
			double win = 0;
			int cnt = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].equals("W")) {
					if (weights[j] > weights[i])
						cnt++;
					win++;
				}
				if (arr[j].equals("N"))
					continue;
				sum++;
			}
			double rate = ((sum == 0) && (win == 0)) ? 0 : (win / sum) * 100; // 0/0했을경우
			list.add(new boxer(i, rate, cnt, weights[i]));
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).num + 1;
		}
		return answer;
	}
}
