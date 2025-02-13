import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, min, max;
	static int[] nums;
	static int[] oper;
	static int[] operIdx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			oper = new int[4];
			operIdx = new int[N - 1];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			perm(0);
			System.out.println("#" + t + " " + (max - min));
		}
	}

	private static void perm(int depth) {
		if (depth == N - 1) {
			int c = calc();
			min = min > c ? c : min;
			max = max < c ? c : max;
			return;
		}
		int idx = 0;
		while (idx < 4) {
			if (oper[idx] == 0) {
				idx++;
				continue;
			}
			oper[idx]--;
			operIdx[depth] = idx;
			perm(depth + 1);
			oper[idx]++;
			operIdx[depth] = 0;
			idx++;
		}
	}

	private static int calc() {
		int result = nums[0];
		for (int i = 1; i < N; i++) {
			if (operIdx[i - 1] == 0) {
				result += nums[i];
			} else if (operIdx[i - 1] == 1) {
				result -= nums[i];
			} else if (operIdx[i - 1] == 2) {
				result *= nums[i];
			} else if (operIdx[i - 1] == 3) {
				result /= nums[i];
			}
		}
		return result;
	}
}
