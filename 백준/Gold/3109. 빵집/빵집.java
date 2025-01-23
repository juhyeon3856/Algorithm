import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	static int R, C;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄에서 N개의 숫자 입력
		R = Integer.parseInt(st.nextToken()); // 첫 번째 입력: N
		C = Integer.parseInt(st.nextToken()); // 첫 번째 입력: N

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (ch[j] == 'x') {
					map[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			if (dfs(i, 0))
				answer++;
		}

		System.out.println(answer);
	}

	public static boolean dfs(int r, int c) {
		map[r][c] = 1;

		int[] dr = { -1, 0, 1 };
		if (0 <= r && r < R && c == C - 1) {
			return true;
		}
		for (int i = 0; i < 3; i++) {
			if (0 <= r + dr[i] && r + dr[i] < R && c + 1 < C && map[r + dr[i]][c + 1] == 0 && dfs(r + dr[i], c + 1)) {
				return true;
			}
		}
		return false;
	}
}