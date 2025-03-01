import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] pay;
	static int[][] dp;
	static int visited; // bit
	static int inf = Integer.MAX_VALUE/100; //오버플로우 방지를 위한 /100
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		pay = new int[N][N];
		dp = new int[1 << N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pay[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 1 << N; i++) {
			Arrays.fill(dp[i], -1);
		}

		// 입력 및 초기화 완료
		System.out.println(perm(1, 0, 0, 1 << 0));

	}

	private static int perm(int depth, int start, int end, int visited) throws IOException {

		if (depth == N) {
			if (pay[end][start] == 0)
				return inf;
			return dp[visited][end] = pay[end][start]; // 이거 꼭 저장 안해도 됨(어차피 하나마나)
		}
		if (dp[visited][end] != -1) {
			return dp[visited][end];
		}
		dp[visited][end] = inf;
		for (int i = 0; i < N; i++) {
			if ((visited & 1 << i) != 0)
				continue;
			if (pay[end][i] == 0)
				continue;
			int temp = perm(depth + 1, start, i, visited | 1 << i);

			if (pay[end][i] + temp < dp[visited][end]) {
				dp[visited][end] = pay[end][i] + temp;
			}
		}
		return dp[visited][end];

	}

	private static void printdp() {
		for (int i = 0; i < 1 << N; i++) {
			System.out.printf("%4s", Integer.toBinaryString(i));
			System.out.println(Arrays.toString(dp[i]));
		}

	}

}
