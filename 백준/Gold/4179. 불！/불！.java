import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static boolean[][] map;
	static ArrayDeque<int[]> jqueue;
	static ArrayDeque<int[]> fqueue;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		jqueue = new ArrayDeque<>();
		fqueue = new ArrayDeque<>();
		map = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				if (c == '.') {
					map[i][j] = true; // 갈 수 있는 곳은 true;
				} else if (c == 'J') {
					map[i][j] = true;
					jqueue.offer(new int[] { i, j });
				} else if (c == 'F') {
					fqueue.offer(new int[] { i, j });
				}
			}
		}

		answer = 0;
		// 입력 완료 로직 시작 //////////
		while (!jqueue.isEmpty()) {
			answer++;
			fmove();
			if (jmove()) {
				System.out.println(answer);
				return;
			}

		}
		System.out.println("IMPOSSIBLE");
	}

	private static boolean jmove() {
		int size = jqueue.size();
		for (int i = 0; i < size; i++) {
			int[] q = jqueue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];

				if (!check(nr, nc)) {
					jqueue.clear();
					return true;
				}
				if (map[nr][nc]) {
					map[nr][nc] = false;
					jqueue.offer(new int[] { nr, nc });
				}
			}
		}
		return false;
	}

	private static void fmove() {
		int size = fqueue.size();
		for (int i = 0; i < size; i++) {
			int[] q = fqueue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc]) {
					map[nr][nc] = false;
					fqueue.offer(new int[] { nr, nc });
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
