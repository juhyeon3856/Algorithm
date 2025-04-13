import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, answer;
	static boolean[][] map;
	static int[][] visited;
	static ArrayDeque<int[]> queue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		map = new boolean[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], K + 1);
		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) == '1';
			}
		}
		queue = new ArrayDeque<int[]>();

		queue.offer(new int[] { 0, 0, 0, 1 });
		visited[0][0] = 0;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cr = q[0];
			int cc = q[1];
			int ck = q[2];

			if (cr == N - 1 && cc == M - 1) {
				answer = answer > q[3] ? q[3] : answer;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!check(nr, nc))
					continue;
				int nk = map[nr][nc] ? ck + 1 : ck;
				if (nk > K)
					continue;
				if (visited[nr][nc] <= nk)
					continue;
				queue.offer(new int[] { nr, nc, nk, q[3] + 1 });
				visited[nr][nc] = nk;
//				System.out.println("nr : " + nr + ", nc : " + nc + ", nk : " + nk);
			}
		}
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
