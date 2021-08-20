package Level1;

public class 가운데글자가져오기 {

	public String solution(String s) {
		String arr[] = s.split("");
		return (arr.length % 2 != 0) ? arr[arr.length / 2] : arr[(arr.length / 2) - 1] + arr[arr.length / 2];
	}
}
