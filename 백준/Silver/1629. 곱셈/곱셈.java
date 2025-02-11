import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		a %= c;
		long mul = a;

		if (b == 0) {
			System.out.println(1);
			return;
		}

		System.out.println(pow(a, b, c));
		sc.close();
	}

	public static long pow(long A, long B, long C) {
		if (B == 1)
			return A;
		if (B % 2 == 0) {
			long p = pow(A, B / 2, C);
			return p * p % C;
		} else {
			long p = pow(A, (B - 1) / 2, C);
			p = p * p % C;
			return p * A % C;
		}
	}
	

}
