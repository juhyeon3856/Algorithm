import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int start;
	static int N = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[N][N];
			start = 0;

			StringTokenizer st;

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[N - 1][j] = Integer.parseInt(st.nextToken());
				if (map[N - 1][j] == 2) {
					start = j;
				}
			}

			System.out.println("#" + T + " " + go());

		}
	}

	private static int go() {

		int r = N-1;
		int c = start;

		while (r >= 0) {
			if (c - 1 >= 0 && r + 1 < N && map[r][c - 1] == 1) {
				while (map[r + 1][c - 1] == 0) {
					c--;
				}
				c--;
				r--;
			} else if (c + 1 < N && r + 1 < N && map[r][c + 1] == 1) {
				while (map[r + 1][c + 1] == 0) {
					c++;
				}
				c++;
				r--;

			} else {
				r--;
			}
		}
		return c;
	}
}
