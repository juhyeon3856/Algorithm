import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, W;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 5];
		Arrays.fill(dp, -1);
		dp[3] = 1;
		dp[5] = 1;

		for (int i = 6, prev3 = 3, prev5 = 1; i <= N; i++, prev3++, prev5++) {
			if (dp[prev5] != -1) {
				dp[i] = dp[prev5] + 1;
			} else if (dp[prev3] != -1) {
				dp[i] = dp[prev3] + 1;
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);

	}
}
