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
            String first = sc.next();
            int time = sc.nextInt();
            if(first.equals(".o.")){
                if(time%2 == 0){
            		System.out.println("#" + test_case + " " + 1);
                } else {
            		System.out.println("#" + test_case + " " + 0);
                }
            }else if(first.equals("..o")){
                if(time == 0){
            		System.out.println("#" + test_case + " " + 2);
                } else if(time%2 == 0){
            		System.out.println("#" + test_case + " " + 0);
                } else{
            		System.out.println("#" + test_case + " " + 1);
                }
                    
            } else if(first.equals("o..")){
                if(time%2 == 0){
            		System.out.println("#" + test_case + " " + 0);
                } else {
            		System.out.println("#" + test_case + " " + 1);
                }
            } 

		}
	}
}