
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean isStar;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				System.out.print(" ");
			}
			isStar = true;
			for (int j = 0; j < 2 * i + 1; j++) {
				if (isStar) {
					System.out.print("*");
					isStar = !isStar;
				} else {
					System.out.print(" ");
					isStar = !isStar;
				}
			}
			if (i != N - 1) {
				System.out.print("\n");
			}
		}
	}
}