
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, M, R = 3;
	static int answer = 0;
	static List<int[]> virus;
	static int cnt0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		virus = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					cnt0++;
				} else if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}

		solution(0, 0);
		System.out.println(answer);

	}

	private static void solution(int depth, int start) {
		if (depth == R) {
			int safe = bfs();
			if (answer < safe) {
				answer = safe;
			}
			return;
		}
		for (int i = start; i < N * M; i++) {
			int r = i / M, c = i % M;
			if (map[r][c] == 0) {
				map[r][c] = 1;
				solution(depth + 1, i + 1);
				map[r][c] = 0;
			}
		}

	}

	private static int bfs() {
		visited = new boolean[N][M];
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int cnt2 = 0;

		List<int[]> queue = new LinkedList<>();
		for (int[] v : virus) {
			queue.add(v);
		}
		while (!queue.isEmpty()) {
			int[] q = queue.remove(0);
			for (int i = 0; i < 4; i++) {
				int r = q[0] + dr[i];
				int c = q[1] + dc[i];
				if (isCheck(r, c) && map[r][c] == 0 && !visited[r][c]) {
					visited[r][c] = true;
					queue.add(new int[] { r, c });
					cnt2++;
				}
			}
		}
		return cnt0 - cnt2 - 3;

	}

	private static boolean isCheck(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}