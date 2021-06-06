package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약수구하기_1402 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //N
		int K = Integer.parseInt(st.nextToken()); //K
		
		int cnt = 0; 
		//약수 구하기
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) cnt++; // i가 N의 약수라면 카운트 세
			if(cnt == K ) {
				System.out.println(i); //i가 K번째 숫자라면 바로 출력
				break; //for문 빠져나오기.
			} 
		}
		
		if(cnt < K) System.out.println(0); //N의 약수 개수가 K개보다 적으면 0출력
	
		
	}
}
