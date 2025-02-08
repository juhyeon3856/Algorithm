import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] board1;
	static int[][] board2;
	static int N;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] board1 = new int[N][N];
		int[][] board2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'R') {
					board1[i][j] = 1;
					board2[i][j] = 1;
				} else if (str.charAt(j) == 'G') {
					board1[i][j] = 2;
					board2[i][j] = 1;
				} else if (str.charAt(j) == 'B') {
					board1[i][j] = 3;
					board2[i][j] = 3;
				}
			}
		}

		queue = new ArrayDeque<int[]>();
		int answer1 = 0;
		int answer2 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board1[i][j] > 0) {
					queue.add(new int[] { i, j });
					answer1++;
					bfs(board1, board1[i][j]);
				}
				if (board2[i][j] > 0) {
					queue.add(new int[] { i, j });
					answer2++;
					bfs(board2, board2[i][j]);
				}
			}

		}
		System.out.println(answer1 + " " + answer2);

	}

	private static void bfs(int[][] board, int t) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			for (int i = 0; i < 4; i++) {
				int r = q[0] + dr[i];
				int c = q[1] + dc[i];
				if (!check(r, c))
					continue;
				if (board[r][c] == t) {
					board[r][c] = 0;
					queue.offer(new int[] { r, c });
				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
