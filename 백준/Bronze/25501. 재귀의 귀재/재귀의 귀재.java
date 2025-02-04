
import java.util.Scanner;

public class Main {

	static String str;
	static int call;
	static int isPalindrome;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			str = sc.next();
			call = 0;
			isPalindrome = 1;
			recursion(0, str.length()-1);
			System.out.println(isPalindrome + " " + call);
		}

		sc.close();
	}
	
	public static void recursion(int l, int r) {
		call++;
		if(l>=r) { 
			return;
		} else if(str.charAt(l) != str.charAt(r)) {
			isPalindrome = 0;
		} else {
			recursion(l+1, r-1);
		}
	}
}
