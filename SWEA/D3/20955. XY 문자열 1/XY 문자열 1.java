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
            List<String> queue = new LinkedList<>();
            String result = "No";
            boolean reverse = false;
            String S = sc.next();
            String E = sc.next();
            while(S.length() != E.length()){
                if(reverse){
                    if(E.charAt(0)=='Y') reverse = false;
                    E = E.substring(1, E.length());
                } else {
                    if(E.charAt(E.length()-1)=='Y') reverse = true;
                    E = E.substring(0, E.length()-1);
                }
            }
            String resultE = "";
            if(reverse){
                for(int i=E.length()-1;i >=0; i--){
                	resultE += E.substring(i, i+1);
            	}
            } else{
                resultE = E;
            }
            if(S.equals(resultE)){
                    result = "Yes";
            }
            System.out.println("#" + test_case + " " + result);
		}
	}
    
}