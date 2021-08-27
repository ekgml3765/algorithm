package Level2;

public class 피보나치수 {
    public int solution(int n) {
        return Fibo(n);
    }
    static int memo[] = new int[100001];
    public static int Fibo(int n){
        if( n <= 1){
            return n;
        }
        if(memo[n] != 0)
            return memo[n];
        return memo[n] = (Fibo(n-1)%1234567 + Fibo(n-2)%1234567)%1234567;
    }
}
