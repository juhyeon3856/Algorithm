import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int N, sr, sc, er, ec;
	static Deque<int[]> queue;
	static boolean[][] visited;
	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int i = 0; i < TC; i++) {
			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());

			queue = new ArrayDeque<int[]>();
			visited = new boolean[N][N];

			// 입력 완료 로직 시작!!
			System.out.println(bfs());

		}

	}

	private static int bfs() {
		queue.offer(new int[] { sr, sc, 0 });
		visited[sr][sc] = true;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cr = q[0];
			int cc = q[1];
			int ct = q[2];
			
			if(cr == er && cc == ec) {
				return ct;
			}

			for (int d = 0; d < 8; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				int nt = q[2] + 1;

				if (!check(nr, nc))
					continue;
				if (visited[nr][nc])
					continue;
				
				queue.offer(new int[] {nr, nc, nt});
				visited[nr][nc] = true;
			}
		}
		return -1;

	}

	private static boolean check(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

}
