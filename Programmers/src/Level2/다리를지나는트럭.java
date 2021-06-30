package Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10,10,10,10,10,10,10,10,10,10 };
		solution(bridge_length, weight, truck_weights);
	}

	static class Truck{
		int truckWeight;
		int arriveTime;
		public Truck(int truckWeight, int arriveTime) {
			this.truckWeight = truckWeight;
			this.arriveTime = arriveTime;
		}	
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue <Truck> queue = new LinkedList<Truck>();
		for (int i = 0; i < truck_weights.length; i++) {
			queue.add(new Truck(truck_weights[i], 0));
		}
		int time = 1;
		int IngCnt = 0; //건널 수 있는 갯수
		int IngWeight = 0; //건널 수 있는 무게
		Queue <Truck> bridge = new LinkedList<Truck>();
		while(true) {
			//내릴 트럭
			if(!bridge.isEmpty()) {
				if(bridge.peek().arriveTime == time) {
					IngCnt--;
					IngWeight-= bridge.peek().truckWeight;
					bridge.poll();
				}	
			}
			
			//트럭이 다리에 탈 수 있다면
			if(!queue.isEmpty()) {
				Truck truck = queue.peek();
				if( IngWeight + truck.truckWeight <= weight && IngCnt <= bridge_length ) {
					Truck outTruck = queue.poll();
					outTruck.arriveTime = time + bridge_length; //내릴 시간 = 올라탄 시간 + 다리길이
					bridge.add(outTruck);
					IngCnt++; //갯수++
					IngWeight += outTruck.truckWeight;		
				}
			}
		
			if(bridge.isEmpty() && queue.isEmpty())
				break;
			time++;
		}
		answer = time;
		return answer;
	}

}
