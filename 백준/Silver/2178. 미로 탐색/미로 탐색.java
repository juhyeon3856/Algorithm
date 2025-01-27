import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}

		List<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 1 });

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		while (!queue.isEmpty()) {
			int[] q = queue.remove(0);
			if (q[0] == N - 1 && q[1] == M - 1) {
				System.out.println(q[2]);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int r = q[0] + dr[i];
				int c = q[1] + dc[i];
				if (isCheck(r, c) && board[r][c] == 1) {
					board[r][c] = -1;
					queue.add(new int[] { r, c, q[2] + 1 });
				}
			}
		}

	}

	public static boolean isCheck(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}