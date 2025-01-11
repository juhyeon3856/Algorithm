import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int strIdx = 0;
        int endIdx = people.length-1;
        while(strIdx<=endIdx){
            if(people[strIdx] + people[endIdx] <= limit){
                strIdx++;
                endIdx--;
                answer++;
            } else{
                endIdx--;
                answer++;
            }
        }
        return answer;
    }
}