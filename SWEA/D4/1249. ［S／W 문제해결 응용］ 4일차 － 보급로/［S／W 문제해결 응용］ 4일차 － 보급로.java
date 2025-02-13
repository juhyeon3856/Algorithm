import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	static int N;
	static int[][] map;
	static int[][] time;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Cell implements Comparable<Cell> {
		int r;
		int c;
		int cost;

		public Cell(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		public Cell() {
			super();
		}

		@Override
		public int compareTo(Cell o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			time = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			for (int i = 0; i < N; i++) {
				Arrays.fill(time[i], Integer.MAX_VALUE);
			}

			/// 입력완료 로직 시작///////////////////
			int result = bfs();
			System.out.println("#" + t + " " + result);

		}

	}

	private static int bfs() {
		PriorityQueue<Cell> queue = new PriorityQueue<>();
		queue.offer(new Cell(0, 0, map[0][0]));
		time[0][0] = map[0][0];

		while (!queue.isEmpty()) {
			Cell q = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				if (!check(nr, nc))
					continue;
				if (time[nr][nc] > time[q.r][q.c] + map[nr][nc]) {
					time[nr][nc] = time[q.r][q.c] + map[nr][nc];
					queue.offer(new Cell(nr, nc, time[nr][nc]));
				}
			}

		}

		return time[N - 1][N - 1];
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
