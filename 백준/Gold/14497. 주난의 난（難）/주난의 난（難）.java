import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] ju;
	static int[] thief;
	static char[][] map;
	static boolean[][] visited;
	static ArrayDeque<int[]>[] queue;
	static int N, M, answer;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 변수 초기화
		ju = new int[2];
		thief = new int[2];
		map = new char[N][M];
		visited = new boolean[N][M];
		queue = new ArrayDeque[2];
		queue[0] = new ArrayDeque<>();
		queue[1] = new ArrayDeque<>();

		answer = 0;

		st = new StringTokenizer(br.readLine());
		ju[0] = Integer.parseInt(st.nextToken()) - 1;
		ju[1] = Integer.parseInt(st.nextToken()) - 1;
		thief[0] = Integer.parseInt(st.nextToken()) - 1;
		thief[1] = Integer.parseInt(st.nextToken()) - 1;

		visited[ju[0]][ju[1]] = true;
		queue[0].add(ju);

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 입력 완료 로직 시작

		while (!queue[(answer) % 2].isEmpty()) {
			answer++;
			int a = (answer + 1) % 2;
			while (!queue[(answer + 1) % 2].isEmpty()) {
				int[] q = queue[(answer + 1) % 2].poll();
				for (int d = 0; d < 4; d++) {
					int nr = q[0] + dr[d];
					int nc = q[1] + dc[d];
					if (!check(nr, nc))
						continue;
					if (visited[nr][nc])
						continue;
					if (map[nr][nc] == '#') {
						System.out.println(answer);
						return;
					} else if (map[nr][nc] == '0') {
						queue[(answer + 1) % 2].add(new int[] { nr, nc });
						visited[nr][nc] = true;
					} else if (map[nr][nc] == '1') {
						queue[answer % 2].add(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
