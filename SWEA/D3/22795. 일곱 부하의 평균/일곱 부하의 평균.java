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
            int sum = 0;
            int max = 0;
            
            for(int i=0;i<6;i++){
                int size = sc.nextInt();
                sum+= size;
                max = size > max ? size : max;
            }
            
            for(int ts=max+1; ts <= max+8; ts++){
                if((sum+ts)%7==0){
                    System.out.println(ts);
                    break;
                }
            }
            
		}
	}
}