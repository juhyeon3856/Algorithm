import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, check, answer;
	static boolean[][] map, visited;
	static ArrayDeque<int[]>[] queue;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) == '1';
			}
		}
		queue = new ArrayDeque[2];
		queue[0] = new ArrayDeque<int[]>();
		queue[1] = new ArrayDeque<int[]>();

		check = 0;
		queue[check].offer(new int[] { 0, 0 });
		answer = -1;
		visited[0][0] = true;

//		print(map);
		boolean isEnd = false;

		while (!isEnd) {
			int checknext = (check + 1) % 2;
			answer++;
			while (!queue[check].isEmpty()) {
				int[] q = queue[check].poll();
				if (q[0] == N - 1 && q[1] == M - 1) {
					isEnd = true;
					break;
				}

				for (int d = 0; d < 4; d++) {
					int nr = q[0] + dr[d];
					int nc = q[1] + dc[d];
					if (!check(nr, nc))
						continue;
					if (visited[nr][nc])
						continue;
					if (map[nr][nc]) {
						visited[nr][nc] = true;
						queue[checknext].offer(new int[] { nr, nc });
					} else {
						visited[nr][nc] = true;
						queue[check].offer(new int[] { nr, nc });
					}
				}
			}
//			System.out.println();
//			print(visited);
			check = checknext;
		}
		System.out.println(answer);
	}

	private static void print(boolean[][] p) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(p[i]));
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
