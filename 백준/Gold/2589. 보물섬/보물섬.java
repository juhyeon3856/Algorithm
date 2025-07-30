import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static int[][] map;
	static List<int[]> land;
	static ArrayDeque<int[]> queue;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		land = new ArrayList<int[]>();
		queue = new ArrayDeque<int[]>();
		answer = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'L') {
					land.add(new int[] { i, j });
				}
			}
		}
		for (int[] l : land) {
			visited = new boolean[N][M];
			int r = bfs(l[0], l[1]);
			answer = r > answer ? r : answer;
		}
		System.out.println(answer);
	}

	public static int bfs(int r, int c) {
		int result = 0;
		queue.offer(new int[] { r, c, 0 });
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int[] dr = { 0, 0, 1, -1 };
			int[] dc = { 1, -1, 0, 0 };
			for (int i = 0; i < 4; i++) {
				int _r = q[0] + dr[i];
				int _c = q[1] + dc[i];
				if (check(q[0] + dr[i], q[1] + dc[i]) && !visited[_r][_c] && map[_r][_c]=='L') {
					visited[_r][_c] = true;
					result = q[2]+1;
					queue.add(new int[] {_r, _c, result});
				}
			}
		}
		return result;
	}

	private static boolean check(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

}
