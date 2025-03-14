
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N, M, answer;
	static int[][] tree;
	static ArrayDeque<Integer> queue;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		tree = new int[N * M][4];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], -1);
		}
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0][0] = 1;
		System.out.println(dfs(N - 1, M - 1, -1, -1));

	}

	private static int dfs(int cr, int cc, int pr, int pc) {
		int result = 0;
		for (int d = 0; d < 4; d++) {
			int nr = cr + dr[d];
			int nc = cc + dc[d];

			if (!check(nr, nc))
				continue;
			if (map[nr][nc] <= map[cr][cc])
				continue;
			if (visited[nr][nc] != -1) {
				result += visited[nr][nc];
				continue;
			}
			result += dfs(nr, nc, cr, cc);
		}
		visited[cr][cc] = result;
		return visited[cr][cc];

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
