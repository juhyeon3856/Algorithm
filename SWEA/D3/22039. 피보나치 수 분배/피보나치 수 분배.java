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
			int N =sc.nextInt();
            if(N%3==0){
                String result = "";
                for(int i=0; i<N/3; i++){
                    result += "BBA";
                }
                System.out.println(result);
            } else if(N%3 == 2){
                String result = "BA";
                for(int i=0; i<N/3; i++){
                    result += "BBA";
                }
                System.out.println(result);
            } else {
                System.out.println("impossible");
            }
		}
	}
}