class Solution {
    public int solution(int[][] dots) {
        if(getSlope(dots[0], dots[1]) == getSlope(dots[2], dots[3]) ||
           getSlope(dots[0], dots[2]) == getSlope(dots[1], dots[3]) ||
           getSlope(dots[0], dots[3]) == getSlope(dots[1], dots[2])){
            return 1;
        } else{
            return 0;
        }
    }
    public double getSlope(int[] x1, int[] x2){
        return (double) (x1[1] - x2[1]) / (x1[0] - x2[0]);
    }
}

