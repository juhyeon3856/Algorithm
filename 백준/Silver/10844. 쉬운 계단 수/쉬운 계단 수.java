import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[12][2]; // 0->1, 9->10

		for (int i = 2; i <= 10; i++) {
			dp[i][0] = 1;
		}
		int check = 0;

		for (int i = 2; i <= N; i++) {
			check = (check + 1) % 2;
			for (int j = 1; j <= 10; j++) {
				dp[j][check] = (dp[j - 1][(check + 1) % 2] + dp[j + 1][(check + 1) % 2])%1000000000;
			}
		}

		int answer = 0;
		for (int i = 1; i <= 10; i++) {
			answer += dp[i][check];
			answer %= 1000000000;
		}
		System.out.println(answer);

	}
}
