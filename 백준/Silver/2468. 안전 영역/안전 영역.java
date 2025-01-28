import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int T, N;
	static int[][] board;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		int max = 0;
		int answer = 0;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > max)
					max = board[i][j];
			}
		}

		for (int i = 0; i <= max; i++) {
			int s = sol(i);
			if (s >= answer) {
				answer = s;
			}
		}
		System.out.println(answer);

	}

	public static int sol(int num) {
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] > num) {
					cnt++;
					board[i][j] *= -1;
					adjacet(i, j, num);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] < -1 * num) {
					board[i][j] *= -1;
					disAdjacet(i, j, num);
				}
			}
		}
		return cnt;
	}

	public static void adjacet(int r, int c, int num) {

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			if (isCheck(r + dr[i], c + dc[i]) && board[r + dr[i]][c + dc[i]] > num) {
				board[r + dr[i]][c + dc[i]] *= -1;
				adjacet(r + dr[i], c + dc[i], num);
			}
		}
	}

	public static void disAdjacet(int r, int c, int num) {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			if (isCheck(r + dr[i], c + dc[i]) && board[r + dr[i]][c + dc[i]] < -1 * num) {
				board[r + dr[i]][c + dc[i]] *= -1;
				disAdjacet(r + dr[i], c + dc[i], num);
			}
		}
	}

	public static boolean isCheck(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}