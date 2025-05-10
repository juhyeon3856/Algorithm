import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K, answer;
	static boolean visited[];
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		p = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken()) - K;
		}

		perm(0, 0);

		System.out.println(answer);
	}

	private static void perm(int depth, int tot) {
		// 중량이 500미만이 되면 그 case는 더 이상 하지 않아도 됨.
		if (tot < 0) {
			return;
		}
		// 모든 경우에 tot > 0으로 된 조합 : 즉 항상 중량이 500이상 -> 가능한 case 
		if (depth == N) {
			answer++;
			return;
		}
		// perm 
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			perm(depth + 1, tot + p[i]);
			visited[i] = false;
		}
	}

}
