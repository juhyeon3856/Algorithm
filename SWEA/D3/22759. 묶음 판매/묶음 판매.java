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
            int L = sc.nextInt();
            int R = sc.nextInt();
            
            if(R < 2*L){
                System.out.println("yes");
            } else{
                System.out.println("no");
            }
                
		}
	}
}