import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] p;
	static int[] nums;
	static int N, R;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		nums = new int[R];
		p = new int[N];
		visited = new boolean[N];
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(p);

		perm(0);
		System.out.println(sb);

	}

	private static void perm(int depth) {
		if (depth == R) {
			for (int i = 0; i < R; i++) {
				sb.append(nums[i] + " ");
			}
			sb.append("\n");
			return;
		}
		int beforeNum = -1;
		for (int i = 0; i < N; i++) {
			if (visited[i] || beforeNum==p[i])
				continue;
			visited[i] = true;
			nums[depth] = p[i];
			perm(depth + 1);
			visited[i] = false;
			nums[depth] = 0;
			beforeNum = p[i];

		}
	}

}
