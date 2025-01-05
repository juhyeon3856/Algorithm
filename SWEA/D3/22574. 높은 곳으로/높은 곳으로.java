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
            int P = sc.nextInt();
            boolean isP = false;
            int answer = 0;
            
            for(int i=1; i<=N; i++){
                answer += i;
                if(answer == P){
                    isP = true;
                }
            }
            
            if(isP){
                System.out.println(answer-1);
            }else{
                System.out.println(answer);
            }
		

		}
	}
}