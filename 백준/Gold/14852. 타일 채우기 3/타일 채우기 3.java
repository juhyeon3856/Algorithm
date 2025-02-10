import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
	    long[] l = new long[N + 3];
		l[0] = 1;
		l[1] = 2;
		l[2] = 7;
		int num = 3;
		while (num <= N) {
			l[num] = ((l[num - 1] * 3) % 1000000007 + l[num - 2] % 1000000007 - l[num - 3] % 1000000007 + 1000000007)
					% 1000000007;
			num++;
		}
		System.out.println(l[N]);
	}
}
