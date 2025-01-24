import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			if(i==N-1) {
				for (int j = 0; j < N*2-1; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = 0; j < N - i - 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2 * i + 1; j++) {
					if (j == 0 || j == 2 * i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.print("\n");
			}
			
		}
	}
}