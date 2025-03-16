import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, pay;
	static int N, M, min;
	static int[][] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = N - 2;
		map = new int[N][N];
		pay = new int[M][M];
		min = Integer.MAX_VALUE;
		nums = new int[3][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				pay[i - 1][j - 1] = map[i][j] + map[i - 1][j] + map[i][j - 1] + map[i + 1][j] + map[i][j + 1];
			}
		}
//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(pay[i]));
//		}

		combi(0, 0, 0);
		System.out.println(min);

	}

	private static void combi(int depth, int start, int tot) {
		if (depth == 3) {
			min = min > tot ? tot : min;
//			if (min > tot) {
//				min = tot;
//				System.out.println(min);
//				for (int i = 0; i < 3; i++) {
//					System.out.println(Arrays.toString(nums[i]));
//				}
//				System.out.println();
//			}
			return;
		}
		for (int i = start; i < M * M; i++) {
			int r = i / M;
			int c = i % M;
			if (!check(r, c, depth))
				continue;
			if (tot + pay[r][c] >= min)
				continue;
			nums[depth][0] = r;
			nums[depth][1] = c;
//			System.out.println("depth : " + depth +  ", r: " + r + ", c : " + c);
			combi(depth + 1, i + 1, tot + pay[r][c]);
		}

	}

	private static boolean check(int r, int c, int depth) {
		for (int i = 0; i < depth; i++) {
			int nr = nums[i][0];
			int nc = nums[i][1];
			if (nr == r && nc == c) {
				return false;
			}
			if (Math.abs(r - nr) + Math.abs(c - nc) <= 2)
				return false;
		}
		return true;
	}

}
