import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 }; // 북 > 서 > 남 > 동
	static int[] dc = { 0, -1, 0, 1 };
	static int[] now;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;

		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken());
		sd = (4 - sd) % 4;

		now = new int[] { sr, sc, sd }; // r, c, 보고있는 방향

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.nextToken().equals("0"))
					map[i][j] = 1;
			}
		}
		move();
		System.out.println(answer);
	}

	private static void move() {
		int cr = now[0];
		int cc = now[1];
		int cd = now[2];

		if (map[cr][cc]==1) {
			map[cr][cc] = 2;
			answer++;
		}

		for (int i = 1; i <= 4; i++) {
			int nd = (now[2] + i) % 4;
			int nr = now[0] + dr[nd];
			int nc = now[1] + dc[nd];

			if (check(nr, nc) && map[nr][nc]==1) {
				map[nr][nc] = 2;
				answer++;
				now[0] = nr;
				now[1] = nc;
				now[2] = nd;
				move();
				return;
			}
		}

		int br = now[0] - dr[cd];
		int bc = now[1] - dc[cd];
		if (!check(br, bc) || map[br][bc]==0) {
			return;
		}
		now[0] = br;
		now[1] = bc;
		move();

	}

	private static boolean check(int r, int c) {

		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
