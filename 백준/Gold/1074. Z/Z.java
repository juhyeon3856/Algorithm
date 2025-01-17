import java.util.Scanner;

public class Main {

	static int result=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt(), c = sc.nextInt();
		count((int) Math.pow(2, N), r, c);
		System.out.println(result);
	}
	
	public static void count(int n, int i, int j) {
		if(n==2) {
			result+=i*2+j;
		} else {
			int m=n/2;
			if(i<m && j<m) {			//왼쪽 위
				count(m, i, j);
			} else if(i<m && j>=m) {	//오른쪽 위
				result+=m*m;
				count(m, i, j-m);
			} else if(i>=m && j<m) {	//왼쪽 아래
				result+=m*m*2;
				count(m, i-m, j);
			} else if(i>=m && j>=m) {	//오른쪽 아래
				result+=m*m*3;
				count(m, i-m, j-m);
			} 
		}
	}
}