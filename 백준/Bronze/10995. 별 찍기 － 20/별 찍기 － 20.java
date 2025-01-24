
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean isStar;
		for (int i = 1; i < N+1; i++) {
			if (i % 2 == 1) {
				isStar = true;
				for (int j = 0; j < 2 * N - 1; j++) {
					if (isStar) {
						System.out.print("*");
						isStar = !isStar;
					} else {
						System.out.print(" ");
						isStar = !isStar;
					}
				}
			} else {
				isStar = false;
				for (int j = 0; j < 2 * N; j++) {
					if (isStar) {
						System.out.print("*");
						isStar = !isStar;
					} else {
						System.out.print(" ");
						isStar = !isStar;
					}
				}

			}
			if (i < N) {
				System.out.println();
			}
		}
	}
}