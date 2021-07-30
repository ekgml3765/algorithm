package Level1;

import java.util.Arrays;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		solution(participant, completion);
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		for (int i = 0; i < completion.length; i++) {
			if(!completion[i].equals(participant[i])) {
				answer = participant[i];
				break;
			}
		}
		if(answer.equals(""))
			answer = participant[participant.length-1];
		return answer;
	}
}
