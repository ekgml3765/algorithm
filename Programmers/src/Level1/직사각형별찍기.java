package Level1;

import java.util.Scanner;

public class 직사각형별찍기 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j ++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
