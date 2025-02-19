
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			int pow = N * N;
			int[] idx = { 0, -1 };
			int num = 1;
			int d = 0;
			map = new int[N][N];

			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			while (num <= pow) {
				int nr = idx[0] + dr[d];
				int nc = idx[1] + dc[d];
				if (check(nr, nc) && map[nr][nc] == 0) {
					map[nr][nc] = num;
					num++;
					idx[0] += dr[d];
					idx[1] += dc[d];
				} else {
					d = (d + 1) % 4;
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
