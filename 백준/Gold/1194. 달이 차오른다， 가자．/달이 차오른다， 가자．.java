import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static boolean[][][] visited;
	static char[][] map;
	static Map<Character, Integer> tran;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N, M, min, sr, sc;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;

		visited = new boolean[64][N][M];
		map = new char[N][M];

		tran = new HashMap<>();
		tran.put('A', 0);
		tran.put('B', 1);
		tran.put('C', 2);
		tran.put('D', 3);
		tran.put('E', 4);
		tran.put('F', 5);
		tran.put('a', 0);
		tran.put('b', 1);
		tran.put('c', 2);
		tran.put('d', 3);
		tran.put('e', 4);
		tran.put('f', 5);

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					sr = i;
					sc = j;
					map[i][j] = '.';
				}
			}
		}

		bfs(sr, sc, 0);

	}

	private static void bfs(int r, int c, int dist) throws IOException {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c, dist, 0 });
		visited[0][r][c] = true;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];
				int nd = q[2] + 1;
				int flag = q[3];
				if (!check(nr, nc))
					continue;
				char m = map[nr][nc];
				if (m == '#')
					continue;
				if (m >= 'A' && m <= 'Z' && ((1 << tran.get(m)) & flag) == 0)
					continue;
				if (visited[flag][nr][nc])
					continue;
				if (m >= 'a' && m <= 'z') {
					queue.add(new int[] { nr, nc, nd, flag | 1 << tran.get(m) });
					visited[flag | 1 << tran.get(m)][nr][nc] = true;
				} else if (m == '1') {
					System.out.println(nd);
					return;
				} else {
					queue.offer(new int[] { nr, nc, nd, flag });
					visited[flag][nr][nc] = true;
				}
			}
		}
		System.out.println(-1);

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
