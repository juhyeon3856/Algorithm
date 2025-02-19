import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N = 9, win, lose;
	static int[] p, nums, gu;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p = new int[N];
			gu = new int[N];
			nums = new int[N];
			visited = new boolean[N];
			win = 0;
			lose = 0;

			for (int i = 0; i < N; i++) {
				gu[i] = Integer.parseInt(st.nextToken());
			}

			int pSize = 0;
			for (int j = 1; j <= 2 * N; j++) {
				if (!contain(gu, j)) {
					p[pSize++] = j;
				}
			}


			// 입력완료 로직 시작
			perm(0);
			System.out.println("#" + t + " " + win + " " + lose);

		}

	}

	private static void perm(int depth) {
		if (depth == N) {
			game();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			nums[depth] = i;
			perm(depth + 1);
			visited[i] = false;
		}

	}

	private static void game() {
		int guScore = 0;
		int inScore = 0;
		for (int i = 0; i < 9; i++) {
			if (gu[i] > p[nums[i]]) {
				guScore += gu[i] + p[nums[i]];
			} else {
				inScore += gu[i] + p[nums[i]];
			}
		}
		if (guScore > inScore) { // gu이김
			win++;
		} else if (guScore < inScore) {// gu짐
			lose++;
		}
	}

	private static boolean contain(int[] list, int num) {
		for (int n : list) {
			if (num == n)
				return true;
		}
		return false;
	}

}
