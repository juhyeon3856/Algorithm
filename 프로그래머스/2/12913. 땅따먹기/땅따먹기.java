import java.util.*;

class Solution {
    int solution(int[][] land) {
        int max=0;
        for(int i=1; i<land.length;i++){
            for(int j=0; j<4; j++){
                max = 0;
                for(int k=0; k<4; k++){
                    if(j==k){
                        continue;
                    }else if(land[i-1][k] > max){
                        max = land[i-1][k];
                    }
                }
                land[i][j] += max;
            }
        }
        max = 0;
        for(int k=0; k<4; k++){
            if(land[land.length-1][k] > max){
                max = land[land.length-1][k];
            }
        }
        return max;
    }
}