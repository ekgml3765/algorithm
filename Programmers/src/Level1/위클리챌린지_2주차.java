package Level1;

public class 위클리챌린지_2주차 {
    public String solution(int[][] scores) {
        String answer = "";
        for(int j = 0; j < scores.length; j++){
            double avg = 0;
            double sum = 0;
            int cnt = 0;
            int min = 100;
            int max = 0;
            boolean flag = true;
            for(int i = 0; i < scores.length; i++){
                sum += scores[i][j];
                cnt++;
                min = Math.min(min, scores[i][j]);
                max = Math.max(max, scores[i][j]);
                if(i != j && scores[j][j] == scores[i][j])
                    flag = false;
            }
            
            if(flag && (min == scores[j][j] || max == scores[j][j])){
                sum -= scores[j][j];
                cnt--;
            }
            avg = sum/cnt;
            if( avg >= 90)
                answer += "A";
            if(avg >= 80 && avg < 90)
                answer += "B";
            if(avg >= 70 && avg < 80)
                answer += "C";
            if(avg >= 50 && avg < 70)
                answer += "D";
            if(avg <50)
                answer += "F";
                
        }
        return answer;
    }
}
