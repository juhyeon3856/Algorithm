
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static boolean[] visited;
	static int[] p;
	static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			p = new int[N];
			visited = new boolean[N];
			answer = 0;

			for (int i = 0; i < N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			// 입력 완료 로직 시작 ----------------------------

			perm(0, 0, 0);
			System.out.println("#" + test_case + " " + answer);
		}

	}

	private static void perm(int depth, int leftSum, int rightSum) {
		if (leftSum < rightSum)
			return;
		if (depth == N) {
			answer++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;

			perm(depth + 1, leftSum + p[i], rightSum); // 왼쪽에 넣는 것
			perm(depth + 1, leftSum, rightSum + p[i]); // 오른쪽에 넣는 것

			visited[i] = false;
		}
	}
}
