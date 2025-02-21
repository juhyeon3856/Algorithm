import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int goal = sc.nextInt();
		int[] coins = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			coins[i] = sc.nextInt();
		}

		Arrays.sort(coins);

		int[][] count = new int[N + 1][goal + 1];

		for (int coinIdx = 1; coinIdx <= N; coinIdx++) {
			int coin = coins[coinIdx];
			for (int countIdx = 1; countIdx <= goal; countIdx++) {
				if (coin == countIdx) {
					count[coinIdx][countIdx]++;
				}
				if (countIdx - coin >= 0) {
					count[coinIdx][countIdx] += count[coinIdx][countIdx - coin];
				}
				count[coinIdx][countIdx] += count[coinIdx - 1][countIdx];
			}
		}
		System.out.println(count[N][goal]);
		sc.close();
	}
}
