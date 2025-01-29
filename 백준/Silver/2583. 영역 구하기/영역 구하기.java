
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int N, M;
	static int cnt;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		board = new int[M][N];
		answer = new int[N * M];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());

			for (int j = X1; j < X2; j++) {
				for (int j2 = Y1; j2 < Y2; j2++) {
					board[j][j2] = 1;
				}
			}

		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		answer = Arrays.copyOfRange(answer, 0, cnt);
		Arrays.sort(answer);
		System.out.println(cnt);

		for (int i = 0; i < cnt; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();
	}

	public static void dfs(int r, int c) {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		answer[cnt] += 1;
		board[r][c] = -1;

		for (int i = 0; i < 4; i++) {
			if (r + dr[i] >= 0 && r + dr[i] < M && c + dc[i] >= 0 && c + dc[i] < N
					&& board[r + dr[i]][c + dc[i]] == 0) {
				dfs(r + dr[i], c + dc[i]);
			}
		}
	}
}