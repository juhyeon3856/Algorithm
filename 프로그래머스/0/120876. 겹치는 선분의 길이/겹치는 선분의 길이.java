import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        List<Integer> check = new LinkedList<>();
        List<Integer> addAnswer = new LinkedList<>();
        for(int i=0; i<lines.length; i++){
            for(int j=lines[i][0]; j<lines[i][1];j++){
                if(check.contains(j) && !addAnswer.contains(j)){
                    answer++;
                    addAnswer.add(j);
                } else if(!check.contains(j)){
                    check.add(j);
                }
            }
        }
        return answer;
    }
}