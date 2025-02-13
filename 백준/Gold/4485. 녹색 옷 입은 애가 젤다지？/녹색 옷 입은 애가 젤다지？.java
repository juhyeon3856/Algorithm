import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static int[][] cost;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

/////////class만들어서 쓰기//////////////////////////
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
	};
/////////class만들어서 쓰기 끝!//////////////////////////

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int cnt = 1;
		while (true) {
			N = sc.nextInt();
			if (N == 0)
				break;
			map = new int[N][N];
			cost = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = bfs();
			System.out.println("Problem " + (cnt++) + ": " + result);

		}
	}

	static int bfs() {
		// 순서가 있으니까 더 효율적임
		PriorityQueue<Cell> que = new PriorityQueue<>();
		que.offer(new Cell(0, 0, map[0][0]));
		cost[0][0] = map[0][0];
		while (!que.isEmpty()) {
			Cell cur = que.poll();
			int cr = cur.r;
			int cc = cur.c;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!check(nr, nc))
					continue;
				if (cost[nr][nc] > cost[cr][cc] + map[nr][nc]) {
					cost[nr][nc] = cost[cr][cc] + map[nr][nc];
					que.offer(new Cell(nr, nc, cost[nr][nc]));
				}
			}

		}
//		System.out.println(Arrays.deepToString(cost));
		return cost[N - 1][N - 1];
	}

	private static boolean check(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
