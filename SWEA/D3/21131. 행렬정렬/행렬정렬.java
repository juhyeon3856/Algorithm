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
            boolean[] transpose = new boolean[N-1];
            int[][] A = new int[N][N];
            int result = 0;
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    A[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<N-1; i++){
                transpose[i] = A[i][i] == A[i][i+1] -1;
            }
            
            for(int i=N-2; i>=0; i--){
                if(transpose[i] ^ (result%2==0)){
                    result++;
                }
            }
            System.out.println(result);
		}
	}
}