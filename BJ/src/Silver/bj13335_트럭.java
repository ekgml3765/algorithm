package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13335_트럭 {

	static class Truck{
		int weight;
		int arrive;
		public Truck(int weight, int arrive) {
			this.weight = weight;
			this.arrive = arrive;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Queue<Truck> queue = new LinkedList<>();
		Queue<Truck> bridge = new LinkedList<>();
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n ; i++) {
			queue.add(new Truck(Integer.parseInt(st.nextToken()), 0));
		}
		int time = 1;
		int currWeight = 0;
		int ans = 0;
		while(!queue.isEmpty()) {
			if(!bridge.isEmpty()) {
				if(bridge.peek().arrive == time) {
					Truck truck = bridge.poll();
					currWeight -= truck.weight;
				}
			}
			if(bridge.size() + 1 <= w && currWeight + queue.peek().weight <= L) {
				Truck truck = queue.poll();
				truck.arrive = time + w;
				bridge.add(truck);
				currWeight += truck.weight;
			}
			time++;
		}
		while(!bridge.isEmpty()) {
			ans = bridge.poll().arrive;
		}
		System.out.println(ans);
	}
}
