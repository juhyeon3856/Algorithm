import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int N, R;
	static int[][] board;
	static List<int[]> blank;
	static int blankSize;
	static boolean check;

	public static void main(String[] args) throws IOException {
		blank = new ArrayList<int[]>();
		board = new int[9][9];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0)
					blank.add(new int[] { i, j });
			}
		}
		blankSize = blank.size();
		sol(0);

	}

	public static void sol(int depth) {
		if (depth == blankSize) {
			print();
			check = true;
			return;
		}
		int br = blank.get(depth)[0];
		int bc = blank.get(depth)[1];
		int[] fNum = find(br, bc);
		for (int f : fNum) {
			if (!check && horizontal(br, bc, f) && vertical(br, bc, f)) {
				board[br][bc] = f;
				sol(depth + 1);
				board[br][bc] = 0;
			}
		}
	}

	public static int[] find(int r, int c) {
		int sr = r - r % 3;
		int sc = c - c % 3;
		boolean[] isExist = new boolean[9];
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[sr + i][sc + j] == 0)
					continue;
				isExist[board[sr + i][sc + j] - 1] = true;
				cnt++;
			}
		}
		int[] notExist = new int[9 - cnt];
		int idx = 0;

		for (int i = 0; i < 9; i++) {
			if (!isExist[i]) {
				notExist[idx++] = i + 1;
			}
		}

		return notExist;

	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static boolean horizontal(int r, int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (board[i][c] == n)
				return false;
		}
		return true;

	}

	public static boolean vertical(int r, int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == n)
				return false;
		}
		return true;
	}

}
