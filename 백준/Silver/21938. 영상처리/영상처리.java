import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N, M, K, answer;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayDeque<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())
						+ Integer.parseInt(st.nextToken());
			}
		}

		K = Integer.parseInt(br.readLine()) * 3;
		answer = 0;

		queue = new ArrayDeque<int[]>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] >= K) {
					answer++;
					bfs(i, j);

				}
			}
		}
		System.out.println(answer);

	}

	private static void bfs(int r, int c) {
		queue.offer(new int[] { r, c });
		map[r][c] = -1;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] >= K) {
					queue.offer(new int[] { nr, nc });
					map[nr][nc] = -1;
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
