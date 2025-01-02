class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int moveIdx = 0;
        int num = 1;
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x=0, y=-1;
        while(num<=n*n){
            x += move[moveIdx][0];
            y += move[moveIdx][1];
            
            if(x>=0 && x<n && y>=0 && y<n && answer[x][y]==0){
                answer[x][y]=num;
                num++;
            }else{
                x -= move[moveIdx][0];
                y -= move[moveIdx][1];
                moveIdx = (moveIdx+1)%4;
            }
        }
        return answer;
    }
}