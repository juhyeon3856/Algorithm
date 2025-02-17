import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, N, time;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		time = 1;
		map = new int[R][C];

		// 짝수일 때는 무조건 다 채워져있음
		if (N % 2 == 0) {
			print();
			return;
		}

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == '.') {
					map[i][j] = time;
				}
			}
		}
		if (N == 1) {
			print();
			return;
		}

		// 1, 5, 9, ...는 동일함
//		if (N % 4 == 3) {
		// 3, 7, 11, ...의 경우 동일함
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] < time) {
					map[r][c] = time + 1;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (!check(nr, nc) || map[nr][nc] < time)
							continue;
						map[nr][nc] = time + 1;
					}
				}
			}
		}
		time++;
		
//		print();
		if (N % 4 == 3) {
			print();
		}

		if (N % 4 == 1) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] < time) {
						map[r][c] = time + 1;
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (!check(nr, nc) || map[nr][nc] < time)
								continue;
							map[nr][nc] = time + 1;
						}
					}
				}
			}
			time++;
			print();
			return;
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] < time) {
					sb.append("O");
				} else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

//O
