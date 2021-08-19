package Level1;
import java.util.*;

class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int k = 0 ; k < moves.length; k++){
            int j = moves[k]-1;
            for(int i = 0; i < board.length; i++){
                if(board[i][j]!=0){
                    int num = board[i][j];
                    board[i][j] = 0;
                    if(stack.isEmpty()){
                        stack.add(num);
                    }else{
                        if(stack.peek() == num){
                            stack.pop();
                            answer+=2;
                        }else{
                            stack.add(num);
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}