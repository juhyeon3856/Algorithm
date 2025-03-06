import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	static int N, answer;
	static int[] p;
	static int[][] d2 = { { -9, -3 }, { -3, -9 } };
	static int[][] d3 = { { -9, -3, -1 }, { -9, -1, -3 }, { -3, -9, -1 }, { -3, -1, -9 }, { -1, -3, -9 },
			{ -1, -9, -3 } };
	static boolean[][][] visited;
	static ArrayDeque<int[]> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		p = new int[N];

		for (int i = 0; i < N; i++) {
			p[i] = sc.nextInt();
		}
		queue = new ArrayDeque<>();
		queue.offer(p);

		if (N == 3) {
			visited = new boolean[61][61][61];
			visited[p[0]][p[1]][p[2]] = true;
		} else if (N == 2) {
			visited = new boolean[61][61][1];
			visited[p[0]][p[1]][0] = true;
		}

		answer = 0;
		// 입력 완료 로직 시작
		bfs();
		System.out.println(answer);
		sc.close();
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] q = queue.poll();
				// 종료 조건 체크
				boolean isEnd = true;
				for (int j = 0; j < N; j++) {
					if (q[j] > 0) {
						isEnd = false;
						break;
					}
				}
				if (isEnd)
					return;

				// 개수에 따라서 queue에 추가
				if (N == 1) {
					queue.offer(new int[] { q[0] - 9 });
				} else if (N == 2) {
					for (int j = 0; j < 2; j++) {
						int n1 = q[0] + d2[j][0] < 0 ? 0 : q[0] + d2[j][0];
						int n2 = q[1] + d2[j][1] < 0 ? 0 : q[1] + d2[j][1];
						if (!visited[n1][n2][0]) {
							queue.offer(new int[] { n1, n2 });
							visited[n1][n2][0] = true;
						}
					}
				} else if (N == 3) {
					for (int j = 0; j < 6; j++) {
						int n1 = q[0] + d3[j][0] < 0 ? 0 : q[0] + d3[j][0];
						int n2 = q[1] + d3[j][1] < 0 ? 0 : q[1] + d3[j][1];
						int n3 = q[2] + d3[j][2] < 0 ? 0 : q[2] + d3[j][2];
						if (!visited[n1][n2][n3]) {
							queue.offer(new int[] { n1, n2, n3 });
							visited[n1][n2][n3] = true;
						}
					}

				}
			}
			answer++;
		}
	}
}
