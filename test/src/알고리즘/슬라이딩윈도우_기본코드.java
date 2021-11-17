package 알고리즘;

public class 슬라이딩윈도우_기본코드 {

	public static void main(String[] args) {
		int arr[] = {2,3,4,1,5};
		int window = 3; //고정된 윈도우 크기
		
		int start = 0;
		int max = Integer.MIN_VALUE; // 연속된 배열에서 최대 크기 찾는다고 했을 때
		int sum = 0;
		
//		//i는 end
//		for (int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//			//지금까지 더해온 길이가 window크기다?
//			if(i-start+1 == window) {
//				//갱신
//				max = Math.max(max, sum);
//				//창문 왼쪽 끝값 삭제
//				sum -= arr[start];
//				start++;
//			}
//		}
		
		//start 필요없는 코드
		for (int i = 0; i < arr.length; i++) {
			if(i >= window) {
				sum -= arr[i-window];
			}
			sum += arr[i];
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}
}
