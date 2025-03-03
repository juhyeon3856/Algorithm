import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N, white, blue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		white = 0;
		blue = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		func(0, 0, N);
		System.out.println(white);
		System.out.println(blue);

	}

	private static void func(int r, int c, int n) {
		if (isEnd(r, c, n))
			return;
		int m = n / 2;
		func(r, c, m);
		func(r + m, c, m);
		func(r, c + m, m);
		func(r + m, c + m, m);
	}

	private static boolean isEnd(int r, int c, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += map[r + i][c + j];
			}
		}
		if (sum == 0) {
			white++;
			return true;
		} else if (sum == n * n) {
			blue++;
			return true;
		}
		return false;
	}

}
