import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, answer;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[26];
		answer = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		visited[map[0][0]-'A'] = true;
		dfs(1, 0, 0);
		System.out.println(answer);
	}

	private static void dfs(int depth, int r, int c) {
		boolean isEnd = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (!check(nr, nc))
				continue;
			if (visited[map[nr][nc]-'A'])
				continue;
			visited[map[nr][nc]-'A'] = true;
			dfs(depth + 1, nr, nc);
			visited[map[nr][nc]-'A'] = false;
			isEnd = false;

		}
		if (isEnd) {
			answer = answer < depth ? depth : answer;
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}


