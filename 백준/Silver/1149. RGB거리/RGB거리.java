import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[3]; // 0->1, 9->10

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int r = Math.min(dp[1] + R, dp[2] + R);
			int g = Math.min(dp[0] + G, dp[2] + G);
			int b = Math.min(dp[0] + B, dp[1] + B);
			dp[0] = r;
			dp[1] = g;
			dp[2] = b;
		}
		int answer = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			answer = Math.min(answer, dp[i]);
		}
		System.out.println(answer);

	}
}
