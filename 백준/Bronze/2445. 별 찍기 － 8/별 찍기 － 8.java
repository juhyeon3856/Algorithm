import java.util.Scanner;

public class Main {

	static int N;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0; i<2*N-1; i++) {
			for(int j=0; j<N-abs(N-i-1); j++) {
				System.out.print("*");
			}
			for(int j=0; j<2*abs(N-i-1); j++) {
				System.out.print(" ");
			}
			for(int j=0; j<N-abs(N-i-1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static int abs(int n) {
		return n>0 ? n: -1*n;
	}
}