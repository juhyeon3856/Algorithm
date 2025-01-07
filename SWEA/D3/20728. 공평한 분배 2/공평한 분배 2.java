import java.util.*;
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
            int K = sc.nextInt();
            int[] A = new int[N];
            long result = 1;
            for(int i=0; i<9; i++){
                result *= 10;
            }
            
            for(int i=0; i<N; i++){
            	A[i] = sc.nextInt();
            }
            Arrays.sort(A);
            for(int i=0; i<N-K+1; i++){
            	result = result > A[K+i-1] - A[i] ?  A[K+i-1] - A[i] : result;
            }
            System.out.println("#" + test_case + " " + result);

		}
	}
}