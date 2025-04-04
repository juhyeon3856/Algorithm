import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[][] visited;
	static int[][] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		paper = new int[n][n];
		visited = new long[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] != 0 && paper[i][j] != 0) {
					int add = paper[i][j];
					if (check(i + add, j))
						visited[i + add][j] += visited[i][j];
					if (check(i, j + add))
						visited[i][j + add] += visited[i][j];
				}
			}
		}

//		for (int k = 0; k < n; k++) {
//			System.out.println(Arrays.toString(visited[k]));
//		}
//		System.out.println();

		System.out.println(visited[n - 1][n - 1]);

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < n && nc < n;
	}
}
