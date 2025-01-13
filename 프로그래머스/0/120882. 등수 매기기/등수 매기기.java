import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        float[] avg = new float[score.length];
        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            avg[i] = (float) (score[i][0] + score[i][1]) / 2;
        }
        Arrays.sort(avg);
        for(int i=0; i<score.length; i++){
            int idx = score.length;
            float a = (float) (score[i][0] + score[i][1]) / 2;
            for(int j=0; j<score.length; j++){
                if(avg[idx-j-1] == a){
                    idx = j+1;
                    break;
                }
            }
            answer[i] = idx;
        }
        return answer;
    }
}