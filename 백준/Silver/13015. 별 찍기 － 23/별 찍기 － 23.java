import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int m = N - 1;
		for (int i = 0; i < 2 * m + 1; i++) {
			if (i == 0 || i == 2 * m) {
				for (int j = 0; j < N; j++) {
					System.out.print("*");
				}
				for (int j = 0; j < 2 * m - 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < N; j++) {
					System.out.print("*");
				}
				System.out.println();
			} else {
				int absM = Math.abs(i - m);
				for (int j = 0; j < Math.abs(i - m) + 3 * m + 1; j++) {
					if (j == m - absM || j == 2 * m - absM || j == m * 2 + absM || j == m * 3 + absM) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
