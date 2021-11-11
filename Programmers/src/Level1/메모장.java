package Level1;

class 메모장 {
    public int solution(int K, String[] words) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        for(int i = 0; i < words.length; i++){
            //System.out.println("시작"+ " " +i);
            ++answer;
            int idx = i;
            int max = 0;
            while(idx < words.length){
                max += words[idx].length();
                //System.out.println(max);
                if(max > K)
                    break;
                max++;
                idx++;
            }
            i = idx-1;
        }
        return answer;
    }
}
