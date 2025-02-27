import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] tree;
	static int max;
	static int two, one;
	static StringBuilder sb = new StringBuilder();
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			one = 0;
			two = 0;
			result = 0;
			max = 0;
			int N = Integer.parseInt(br.readLine());
			tree = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}
			for (int i = 0; i < N; i++) {
				tree[i] = max - tree[i];
				if ((tree[i] & 1) == 0) { // 짝수니~~?
					two += tree[i] / 2;
				} else {
					two += tree[i] / 2;
					one++;
				}
			}
			if (one == two) {
				result = one * 2;
			} else if (one > two) {
				result = one * 2 - 1;
			} else {
				int sum[] = { 0, 2, 3 };
				int C = two - one;
				result = one * 2 + (4 * (C / 3)) + sum[C % 3];
			}
			sb.append("#").append(TC).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
