package Level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 모의고사 {

	static int first[] = {1,2,3,4,5};
	static int second[] = {2,1,2,3,2,4,2,5};
	static int third[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int [] answers = new int [5];
		StringTokenizer st = new StringTokenizer(in.readLine(), ",");
		for (int i = 0; i < answers.length; i++) {
			answers[i] = Integer.parseInt(st.nextToken());
		}
		solution(answers);
	}

	static public int[] solution(int[] answers) {
		int[] answer = {};
		int people[] = new int [3];
		int max = Integer.MIN_VALUE;
		//3명의 사람 맞은 갯수 비교
		for (int i = 0; i < 3; i++) {
			int arr[] = {};
			int size;
			int idx = 0;
			if(i == 0) {
				arr = first;
			}
			if(i == 1) {
				arr = second;
			}
			if(i == 2) {
				arr = third;
			}
				
			for (int j = 0; j < answers.length; j++) {
				if(answers[j] == arr[idx])
					people[i]++;
				idx++;
				if(idx == arr.length) idx = 0;
			}
			max = Integer.max(max, people[i]);
		}
		
		List list = new ArrayList<Integer>();
		for (int i = 0; i < people.length; i++) {
			if(people[i]==max)
				list.add(i+1);
		}
		
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = (int) list.get(i);
		}
		//System.out.println("정답"+Arrays.toString(answer));
		return answer;
	}
}
