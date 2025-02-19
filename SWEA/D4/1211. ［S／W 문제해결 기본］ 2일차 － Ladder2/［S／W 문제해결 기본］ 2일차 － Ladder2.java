import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static boolean[] firstLine;
	static int N = 100, minIdx, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[N][N];
			firstLine = new boolean[N];
			min = N*N;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[0][j] = Integer.parseInt(st.nextToken());
				if (map[0][j] == 1) {
					firstLine[j] = true;
				}

			}

			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				if (firstLine[i]) {
//					System.out.println(i);
					int dis = go(i);
					if (min > dis) {
						min = dis;
						minIdx = i;
					}
				}
			}
			System.out.println("#" + T + " " + minIdx);

		}
	}

	private static int go(int start) {
		int result = 0;

		int r = 0;
		int c = start;

		while (r < N) {
			if (c - 1 >= 0 && r + 1 < N && map[r][c - 1] == 1) {
				while (map[r + 1][c - 1] == 0) {
					c--;
					result++;
				}
				c--;
				result++;
				r++;
				result++;
			} else if (c + 1 < N && r + 1 < N && map[r][c + 1] == 1) {
				while (map[r + 1][c + 1] == 0) {
					c++;
					result++;
				}
				c++;
				result++;
				r++;
				result++;

			} else {
				r++;
				result++;
			}
		}
		return result;
	}
}
