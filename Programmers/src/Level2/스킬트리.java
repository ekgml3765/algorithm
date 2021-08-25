package Level2;

import java.util.HashMap;

public class 스킬트리 {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			String s = skill_trees[i].replaceAll("[^" + skill + "]", "");
			if (skill.indexOf(s) == 0)
				answer++;
		}
		return answer;
	}
}
