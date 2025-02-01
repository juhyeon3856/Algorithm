
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int N, M;
	static int cheese, answer, turn = 0;
	static List<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					cheese++;
				}
			}
		}

		while (cheese > 0) {
			queue.add(new int[] { 0, 0 });
			board[0][0] = --turn;
			answer = cheese;
			bfs();
		}

		System.out.println(-1 * turn);
		System.out.println(answer);

	}

	private static void bfs() {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int[] q = new int[2];
		while (!queue.isEmpty()) {
			q = queue.remove(0);
			for (int i = 0; i < 4; i++) {
				int r = q[0] + dr[i], c = q[1] + dc[i];
				if (isCheck(r, c)) {
					if (board[r][c] == 1) {
						board[r][c] = turn;
						cheese--;
					} else if (board[r][c] > turn) {
						board[r][c] = turn;
						queue.add(new int[] { r, c });
					}  
				}
			}
		}
	}

	private static boolean isCheck(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}