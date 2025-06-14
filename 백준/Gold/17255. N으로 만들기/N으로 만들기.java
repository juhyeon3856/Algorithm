import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static boolean[] isSame;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		isSame = new boolean[10_000_001];
		isSame[0] = true;
		for (int i = 1; i < 10; i++) {
			int sameNum = i;
			for (int j = 0; j < 7; j++) {
				isSame[sameNum] = true;
				sameNum = sameNum * 10 + i;
			}
		}

		System.out.println(dfs(N, (int) Math.pow(10, Integer.toString(N).length() - 1)));
	}

	private static int dfs(int n, int len) {
		if (isSame[n]) {
			if (!(n != 0 && n / len == 0)) {
				return 1;
			}
		}

		return dfs(n % len, len / 10) + dfs(n / 10, len / 10);
	}

}
