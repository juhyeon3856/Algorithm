import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		int fillIdx = 3;

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			for (int i = fillIdx + 1; i <= N; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
				fillIdx++;
			}
			System.out.println(dp[N]);
		}
	}
}
