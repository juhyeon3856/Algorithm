import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N, M, answer, cnt0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		answer = N * M;
		cnt0 = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 0) {
					cnt0++;
				}
			}
		}

		System.out.println(bfs());

	}

	private static int bfs() {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 1, 2 }); // r, c, cnt, 1을 깬적 있으면 3, 아니면2
		map[0][0] = 2; // 방문했으면 2넣기

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[0] == N - 1 && q[1] == M - 1) {
				return q[2];
			}
			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == 0) {
					map[nr][nc] = q[3];
					queue.offer(new int[] { nr, nc, q[2] + 1, q[3] });
				}
				if (q[3] == 2 && map[nr][nc] == 3) {	//벽을 깨고 그 장소를 지나간 자리에 벽을 안깨고 온 경우가 도착하면 그 경우도 q에 추가
					map[nr][nc] = 2;
					queue.offer(new int[] { nr, nc, q[2] + 1, 2 });
				}
				if (q[3] == 2 && map[nr][nc] == 1) { // 처음 마주한 벽 깨버리기, queue에는 마지막에 1로 넣기
					map[nr][nc] = 4;
					queue.offer(new int[] { nr, nc, q[2] + 1, 3 });
				}

			}
		}
		return -1;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}


