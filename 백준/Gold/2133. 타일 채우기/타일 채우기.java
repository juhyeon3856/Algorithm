import java.util.Scanner;

public class Main  {

	public static long[] l;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N % 2 == 1) {
			System.out.println(0);
			return;
		}
		l = new long[N + 3];
		l[0] = 1;
		l[2] = 3;
		System.out.println(f(N));
	}

	public static long f(int n) {
		if (l[n] == 0) {
			l[n] += f(n - 2);
			for (int i = 0; i < n / 2; i++) {
				l[n] += f(i * 2) * 2;
			}
			return l[n];
		} else {
			return l[n];
		}
	}

}
