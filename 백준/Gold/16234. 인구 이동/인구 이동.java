import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] open;
	static int[][] people;
	static int answer;
	static int L, R, N;
	static boolean isOpen;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		open = new int[N][N];
		people = new int[N][N];
		answer = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		isOpen = true;
		while (isOpen) {
			isOpen = false;
			open = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (open[i][j] == 0) {
						dfs(i, j);
					}
				}
			}
			updatePeople();
			if (isOpen) {
				answer++;
			}
		}
		System.out.println(answer - 1);

	}

	private static void updatePeople() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (open[i][j] != 0) {
					people[i][j] = open[i][j];
				}
			}
		}
	}

	private static void dfs(int r, int c) {
		int openCnt = 0;
		int openSum = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		open[r][c] = -1;
		openSum += people[r][c];
		openCnt++;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cr = q[0];
			int cc = q[1];
			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];
				if (!check(nr, nc))
					continue;
				int dif = Math.abs(people[cr][cc] - people[nr][nc]);
				if (open[nr][nc] != -1 && dif >= L && dif <= R) {
					queue.offer(new int[] { nr, nc });
					open[nr][nc] = -1;
					openSum += people[nr][nc];
					openCnt++;
					isOpen = true;
				}
			}
		}
		aver(openSum / openCnt);
	}

	private static void aver(int avg) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (open[i][j] == -1) {
					open[i][j] = avg;
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
