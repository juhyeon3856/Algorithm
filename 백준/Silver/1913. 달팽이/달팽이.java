
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[][] board = new int[N][N];

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int num = N * N;
		int dIdx = 0;
		int r = -1, c = 0;
		int ar = 0, ac = 0;
		while (num > 0) {
			r += dr[dIdx];
			c += dc[dIdx];
			if (r >= 0 && r < N && c >= 0 && c < N && board[r][c] == 0) {
				if (num == K) {
					ar = r + 1;
					ac = c + 1;
				}
				board[r][c] = num--;
			} else {
				r -= dr[dIdx];
				c -= dc[dIdx];
				dIdx = (dIdx + 1) % 4;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(ar + " " + ac);
	}
}