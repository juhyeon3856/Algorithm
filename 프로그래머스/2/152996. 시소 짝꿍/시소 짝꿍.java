import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> weightData = new HashMap<>();
        for(int i=0;i<weights.length;i++){
            if(weightData.containsKey(weights[i])){
                weightData.put(weights[i], weightData.get(weights[i])+1);
            } else{
                weightData.put(weights[i], 1L);
            }
        }

        // keySet을 배열로 변환
        int[] dataKey = weightData.keySet().stream()
            .mapToInt(Integer::intValue) // Integer -> int 변환
            .toArray();
        Arrays.sort(dataKey);
        for(int i=0;i<dataKey.length;i++){
            for(int j=i+1; j<dataKey.length; j++){
                if(dataKey[i]*2 < dataKey[j]){
                    break;
                }
                if(dataKey[i]*3==dataKey[j]*2 || dataKey[i]*2==dataKey[j] || dataKey[i]*4==dataKey[j]*3){
                    answer += (weightData.get(dataKey[i])*weightData.get(dataKey[j]));
                }
            }
            answer += ((weightData.get(dataKey[i]))*(weightData.get(dataKey[i])-1)/2);
        }
        return answer;
    }
}