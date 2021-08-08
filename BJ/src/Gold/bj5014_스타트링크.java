package Gold;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class bj5014_스타트링크 {
	static class floor{
		int curr;
		int cnt;
		public floor(int curr, int cnt) {
			this.curr = curr;
			this.cnt = cnt;
		}	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
        int button[] = new int[2];
		button[0] = sc.nextInt();
		button[1] = sc.nextInt()*-1;
		int ans = Integer.MAX_VALUE;
		Queue<floor> queue = new LinkedList<floor>();
		boolean visit[] = new boolean[F+1];
		visit[S] = true;
		queue.add(new floor(S, 0));
		while(!queue.isEmpty()) {
			floor f = queue.poll();
			if(f.curr == G) {
				ans = f.cnt;
				break;
			}
			for (int i = 0; i < 2; i++) {
				int num = f.curr + button[i];
				if(num < 1 || num > F || visit[num])
					continue;
				visit[num] = true;
				queue.add(new floor(num, f.cnt + 1));
			}
		}
		if(ans == Integer.MAX_VALUE)
			System.out.println("use the stairs");
		else
			System.out.println(ans);
	}
}
