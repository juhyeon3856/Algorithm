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
            int A = sc.nextInt();
            int B = sc.nextInt();
            int N = sc.nextInt();
            
            int add = A > B ? A : B;
            int base = A > B ? B : A;
            int temp;
            
            int count = 0;
            
            while (add <= N){
                base += add;
                temp = add;
                add = base;
                base = temp;
                count++;
            }
            
            System.out.println(count);
            

		}
	}
}