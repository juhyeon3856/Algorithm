import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main  {
	static int[][][] box;
	static int M, N, H, answer, cnt; // 가로, 세로, 높이, 걸리는 일 수
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];

		queue = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < M; j2++) {
					box[i][j][j2] = Integer.parseInt(st.nextToken());
					if (box[i][j][j2] == 1) {
						queue.add(new int[] { i, j, j2 });
						cnt++;
					} else if (box[i][j][j2] == -1) {
						cnt++;
					}
				}
			}
		}

		// 입력완료 로직 시작 ----------------------------------------
		int[] dm = { -1, 1, 0, 0, 0, 0 };
		int[] dn = { 0, 0, -1, 1, 0, 0 };
		int[] dh = { 0, 0, 0, 0, -1, 1 };

		answer = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				int[] q = queue.poll();
				for (int i = 0; i < 6; i++) {
					int m = q[2] + dm[i];
					int n = q[1] + dn[i];
					int h = q[0] + dh[i];
					if (!check(m, n, h))
						continue;
					if (box[h][n][m] == 0) {
						box[h][n][m] = 1;
						queue.add(new int[] { h, n, m });
						cnt++;
					}
				}
			}
			answer++;
		}
		if (cnt == H * M * N) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}

	}

	public static boolean check(int m, int n, int h) {
		return m >= 0 && m < M && n >= 0 && n < N && h >= 0 && h < H;
	}

}
