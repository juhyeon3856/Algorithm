import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		nums = new int[10]; // 최대 10자리 수

		for (int i = 1; i <= 10; i++) {
			if (N >= 0)
				dfs(0, 10, i);
		}

		if (N >= 0) {
			System.out.println(-1);
		}

	}

	private static void dfs(int depth, int end, int size) {

		if (N < 0) {
			return;
		}
		if (depth == size) {
			if (N-- == 0) {
				for (int i = 0; i < depth; i++) {
					System.out.print(nums[i]);
				}
			}
			return;
		}

		for (int i = 0; i < end; i++) {
			nums[depth] = i;
			dfs(depth + 1, i, size);
		}

	}

}
