import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, W;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		dp = new int[W + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			for (int j = W; j > 0; j--) {
				dp[j] = j >= w ? Math.max(dp[j], v + dp[j - w]) : dp[j];
			}
//			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[W]);

	}
}
