import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] count = new int[K];
		int[] coins = new int[N];
		Arrays.fill(count, -1);

		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}

		int minCoin = Arrays.stream(coins).min().getAsInt();

		for (int c : coins) {
			if (c - 1 < K)
				count[c - 1] = 1;
		}
		for (int i = minCoin; i < K; i++) {
			if (count[i] == -1) {
				int minCount = Integer.MAX_VALUE;
				for (int c : coins) {
					if (i - c >= 0 && minCount > count[i - c] + 1 && count[i - c] != -1)
						minCount = count[i - c] + 1;
				}
				if (minCount < Integer.MAX_VALUE) {
					count[i] = minCount;
				}
			}
		}
		System.out.println(count[K - 1]);
		sc.close();
	}

}
