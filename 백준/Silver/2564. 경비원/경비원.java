import java.util.Scanner;

public class Main {

	static int W;
	static int H;
	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();

		int all = W + W + H + H;

		int N = sc.nextInt();
		int[] loc = new int[N];

		for (int i = 0; i < N; i++) {
			loc[i] = scan();
		}
		int X = scan();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int dis = Math.abs(X - loc[i]);
			answer += Math.min(dis, all - dis);
		}
		System.out.println(answer);
	}

	private static int scan() {
		int[] sum = { 0, 0, W + H, H + W + W, W };
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a == 2)
			b = W - b;
		if (a == 3)
			b = H - b;
		return sum[a] + b;
	}

}
