package Level1;

import java.awt.Point;
import java.util.HashMap;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        Point left = new Point(3,0);
        Point right = new Point(3,2);
        int num = 1;
        HashMap<Integer, Point> map = new HashMap<>();
        for(int i = 0 ; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                map.put(num, new Point(i, j));
                num++;
            }
        }
        map.put(0, new Point(3,1));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i ++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                left.x = map.get(numbers[i]).x;
                left.y = map.get(numbers[i]).y;
                continue;
            }
            if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                right.x = map.get(numbers[i]).x;
                right.y = map.get(numbers[i]).y;
                continue;
            }
            int a = Math.abs(left.x - map.get(numbers[i]).x) + Math.abs(left.y - map.get(numbers[i]).y);
            int b = Math.abs(right.x - map.get(numbers[i]).x) + Math.abs(right.y - map.get(numbers[i]).y);
                if(a < b ||(a==b && hand.equals("left"))){
                    sb.append("L");
                    left.x = map.get(numbers[i]).x;
                    left.y = map.get(numbers[i]).y;
                }else{
                    sb.append("R");
                    right.x = map.get(numbers[i]).x;
                    right.y = map.get(numbers[i]).y;
                }     
        }   
        return sb.toString();
    }
}
