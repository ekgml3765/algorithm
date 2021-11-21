package Level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 그래프_가장먼노드 {
	   static class Node{
	        int num, cnt;
	        public Node(int num, int cnt){
	            this.num = num;
	            this.cnt = cnt;
	        }
	    }
	    public int solution(int n, int[][] edge) {
	        int answer = 0;
	        List<Integer> list[] = new ArrayList[n+1];
	        for(int i = 0; i < list.length; i++){
	            list[i] = new ArrayList<Integer>();
	        }
	        for(int i = 0; i < edge.length; i++){
	            int a = edge[i][0];
	            int b = edge[i][1];
	            list[a].add(b);
	            list[b].add(a);
	        }
	        Queue<Node> queue = new LinkedList<>();
	        boolean visit[] = new boolean[n+1];
	        queue.add(new Node(1, 0));
	        visit[1] = true;
	        int max = 0;
	        int nodeList[] = new int [n+1];
	        while(!queue.isEmpty()){
	            Node node = queue.poll();
	            nodeList[node.num] = node.cnt;
	            max = Math.max(node.cnt, max);
	            for(Integer i : list[node.num]){
	                if(!visit[i]){
	                    visit[i] = true;
	                    queue.add(new Node(i, node.cnt+1));
	                }   
	            }
	        }
	        for(int i : nodeList){
	            if(i == max)
	                answer++;
	        }
	        return answer;
	    }
}
