import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main  {
	static boolean[][] map;
	static int R, C, K, answer;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == 'T')
					map[i][j] = true;
			}
		}

		visited[R - 1][0] = true;
		dfs(1, R - 1, 0);
		System.out.println(answer);

	}

	private static void dfs(int depth, int r, int c) {
		if (depth == K) {
			if (r == 0 && c == C - 1) {
				answer++;
			}
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc))
				continue;
			if (visited[nr][nc])
				continue;
			if (map[nr][nc])
				continue;
			visited[nr][nc] = true;
			dfs(depth + 1, nr, nc);
			visited[nr][nc] = false;
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
