import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static char[][] map;
	static int R = 12, C = 6, answer, minLine;
	static boolean[][] visited, puyo;

	public static void main(String[] args) throws IOException {
		map = new char[R][C];
		answer = 0;
		minLine = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] != '.' && minLine == -1) {
					minLine = i;
				}
			}
		}

		if (minLine == -1) {
			System.out.println(0);
			return;
		}

		while (search()) {
			answer++;
		}

		System.out.println(answer);
	}

	private static boolean search() {
		boolean isPuyo = false;

		visited = new boolean[R][C];
		puyo = new boolean[R][C];

		for (int i = minLine; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '.' && !visited[i][j]) {
					if (bfs(i, j, map[i][j])) {
						isPuyo = true;
					}
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (puyo[i][j]) {
					map[i][j] = '.';
				}
			}
		}
		down();

		return isPuyo;
	}

	private static void down() {
		int _minLine = R;
		for (int i = 0; i < C; i++) {
			int nowIdx = R - 1;
			for (int j = R - 1; j >= minLine; j--) {
				if (map[j][i] == '.')
					continue;
				map[nowIdx--][i] = map[j][i];
			}
			if (nowIdx + 1 < _minLine) {
				_minLine = nowIdx + 1;
			}
			for (int j = nowIdx; j >= minLine; j--) {
				map[j][i] = '.';
			}
		}
		minLine = _minLine;
	}

	private static boolean bfs(int r, int c, char type) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		List<int[]> candi = new ArrayList<>();
		candi.add(new int[] { r, c });
		int idx = 0;
		visited[r][c] = true;

		while (idx < candi.size()) {
			for (int d = 0; d < 4; d++) {
				int nr = candi.get(idx)[0] + dr[d];
				int nc = candi.get(idx)[1] + dc[d];
				if (!check(nr, nc))
					continue;

				if (map[nr][nc] == type && !visited[nr][nc]) {
					visited[nr][nc] = true;
					candi.add(new int[] { nr, nc });
				}
			}
			idx++;
		}

		if (idx >= 4) {
			for (int[] is : candi) {
				puyo[is[0]][is[1]] = true;
			}
			return true;
		}

		return false;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
