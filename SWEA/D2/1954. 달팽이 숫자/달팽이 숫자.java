import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int[][] board = new int[N][N];
            int num = 1;
            int moveIdx = 0;
            int[] idx = {0, -1};
            
            while(num <= N*N){
                int x = idx[0] + moves[moveIdx][0];
                int y = idx[1] + moves[moveIdx][1];
                if(x>=0 && x<N && y>=0 && y<N && board[x][y] == 0){
                    board[x][y] = num;
                    num++;
                    idx[0] = x;
                    idx[1] = y;
                } else{
                    moveIdx = (moveIdx+1)%4;
                }
            }
            
            System.out.println("#"+test_case);
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(board[i][j] + " ");
            	}
                System.out.println();
            }
            
            
		}
	}
}