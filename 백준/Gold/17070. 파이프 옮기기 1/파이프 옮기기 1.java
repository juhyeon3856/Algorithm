import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] dr = { 0, 1, 1 };
		int[] dc = { 1, 1, 0 };

		StringTokenizer st;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 0, 1, 0 }); // r, c, 가로0, 대각선1, 세로2

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[0] == N - 1 && q[1] == N - 1) {
				answer++;
				continue;
			}
			// 가로이면
			int[] fore = new int[2];
			if (q[2] == 0) {
				fore = new int[] { 0, 1 };
			}
			// 대각선이면
			else if (q[2] == 1) {
				fore = new int[] { 0, 1, 2 };
			}
			// 세로이면
			else if (q[2] == 2) {
				fore = new int[] { 1, 2 };
			}

			for (int d : fore) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];
				if (!check(nr, nc, d, N, map))
					continue;
				queue.add(new int[] { nr, nc, d });
			}
		}
		System.out.println(answer);

	}

	private static boolean check(int r, int c, int d, int N, int[][] map) {
		boolean isGo = r >= 0 && r < N && c >= 0 && c < N;
		if (isGo) {
			// 대각선이면
			if (d == 1) {
				if (map[r][c] == 1 || map[r - 1][c] == 1 || map[r][c - 1] == 1)
					return false;
			}
			// 가로이거나 세로이면
			else {
				if (map[r][c] == 1)
					return false;
			}
			return true;
		} else {
			return false;
		}
	}

}
