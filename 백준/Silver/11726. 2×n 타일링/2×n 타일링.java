import java.util.Scanner;
public class Main {

	public static int[] l;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		l = new int[N + 2];
		l[1] = 1;
		l[2] = 2;
		System.out.println(f(N));

	}

	public static int f(int n) {
		if (l[n] == 0) {
			l[n] = (f(n - 1) + f(n - 2))%10007;
			return l[n];
		} else {
			return l[n];
		}
	}

}

