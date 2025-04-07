import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, W;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][W + 1];

//		System.out.println();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= W; j++) {
				dp[i][j] = j >= w ? Math.max(dp[i - 1][j], v + dp[i - 1][j - w]) : dp[i - 1][j];
			}
//			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[N][W]);

	}
}
