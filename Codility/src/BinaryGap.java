import java.util.Arrays;
import java.util.StringTokenizer;

public class BinaryGap {

	public static void main(String[] args) {
		solution(1162);
	}

	public static int solution(int N) {
		int ans = 0;
		String s = Integer.toBinaryString(N);
		StringTokenizer st = new StringTokenizer(s, "1");
		int size = st.countTokens();
		int cnt = 0;
		boolean flag = false;
		if(size == 0) {
			ans = 0;
		}else {
			if(size == 1) {
				if(s.charAt(s.length()-1)-'0' == 1) {
					ans = st.nextToken().length();
				}else {
					ans = 0;
				}		
			}else {
				int num = s.charAt(s.length()-1) - '0';
				num = (num == 0 )? size-1 : size;
				for (int i = 0; i < num ; i++) {
					ans = Math.max(ans, st.nextToken().length());
				}
			}
		}
		return ans;
	}
}
