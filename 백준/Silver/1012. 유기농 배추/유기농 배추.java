
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int T, C, R, N;
	static int[][] board;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄에서 N개의 숫자 입력
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			board = new int[R][C];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				board[r][c] = -1;
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (board[i][j] == -1) {
						cnt++;
						adjacet(i, j);
					}
				}
			}
			System.out.println(cnt);

		}
	}

	public static void adjacet(int r, int c) {

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			if (isCheck(r + dr[i], c + dc[i]) && board[r + dr[i]][c + dc[i]] == -1) {
				board[r + dr[i]][c + dc[i]] = cnt;
				adjacet(r + dr[i], c + dc[i]);
			}
		}
	}

	public static boolean isCheck(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}