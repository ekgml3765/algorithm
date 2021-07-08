package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 방금그곡 {

	public static void main(String[] args) {
		String m = "ABC";
		String[] musicinfos = {
				"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"
		};
		solution(m, musicinfos);
	}

	//글자 리스트로 
	public static String makeList(String m){
		m = m.replaceAll("C#", "c");
		m = m.replaceAll("D#", "d");
		m = m.replaceAll("F#", "f");
		m = m.replaceAll("G#", "g");
		m = m.replaceAll("A#", "a");
		return m;
	}
	
	public static class Node implements Comparable<Node>{
		int time;
		String title;
		int idx;
		public Node(int idx, int time, String title) {
			this.idx = idx;
			this.time = time;
			this.title = title;
		}
		
		@Override
		public int compareTo(Node o) {
			if(o.time == this.time)
				return this.idx - o.idx;
		    return o.time-this.time;
		}
		
	}
	static List<Node> ans = new ArrayList<Node>();
	public static String solution(String m, String[] musicinfos) {
		String answer = "";		
	
		String info[][] = new String[musicinfos.length][];
		for (int i = 0; i < musicinfos.length; i++) {
			String[] s = musicinfos[i].split(",");
			info[i] = s;
		}
		
		//m문자
		String M = makeList(m);
		
		for (int i = 0; i < info.length; i++) {
			String startTime[] = info[i][0].split(":");
			String endTime[] = info[i][1].split(":");
			String title = info[i][2];
			String originMusic = makeList(info[i][3]);
			
			//재생 시간 구하기
			int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
			int end = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
			int time = end - start;
	 
			//음악 원본 문자열로 만들고 실제 재생시간만큼 음악 리스트 생성
			String newMusic = "";
			if(originMusic.length() < time) { //재생시간이 길 때 -> 문자열 더 만들기
					int t = 0;
					int size = originMusic.length();
					for (int j = 0; j < time; j++) {
						if(t == size)
							t = 0;
						newMusic+=Character.toString(originMusic.charAt(t));
						t++;
					}			
			}else { //재생시간이 같거나 작을때 
				for (int j = 0; j < time; j++) {
					newMusic+=Character.toString(originMusic.charAt(j));
				}	
			}

			System.out.println(M);
			System.out.println(newMusic);

			//m이 그문자열에 포함되어있으면 ans배열에 넣어
			if(newMusic.contains(M)) {
				ans.add(new Node(i, time, title));
			}
			
		}
		//ans 길이가 0이면 none출력, 길이가 1보다 크면 재생시간으로 정렬해서 0번째 제목 출력
		if(ans.size() == 0) {
			answer = "(None)";
		}else {
			//정렬
			Collections.sort(ans);
			answer = ans.get(0).title;
		}
		System.out.println("정답:" +answer);
		return answer;
	}

}
