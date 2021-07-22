
public class FrogJmp {

	public static void main(String[] args) {
		solution(10, 85, 30);
	}
    public static int solution(int X, int Y, int D) {
       int ans = 0;
       int num = Y - X;
       if(num % D == 0)
    	   ans = num / D;
       else
    	   ans = (num/D)+1;
       return ans;
    }
}
