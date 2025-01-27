
import java.util.*;

public class Main {

	static int N;
	static int[][] board;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		board = new int[N][N];
		solution(0);
		System.out.println(cnt);

	}

	public static void solution(int depth) {
		if (depth == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (board[depth][i] == 0) {
				attack(depth, i, 1);
				solution(depth + 1);
				attack(depth, i, -1);
			}
		}

	}

	public static void attack(int r, int c, int delta) {
		for (int i = 0; i < N; i++) {
			board[r][i] += delta;
		}
		for (int i = 1; i < N - r; i++) {
			if (c - i >= 0)
				board[r + i][c - i] += delta;
			if (c + i < N)
				board[r + i][c + i] += delta;
			board[r + i][c] += delta;
		}
		board[r][c] += 1000*delta;
	}

}