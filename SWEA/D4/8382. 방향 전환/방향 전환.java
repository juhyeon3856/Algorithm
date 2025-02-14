import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int T, N = 200;
	static int x1, x2, y1, y2;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 }; // 짝 위아래, 홀 양옆
	static int[][][] visited; // 멋진거:)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			x1 = sc.nextInt() + 100;
			y1 = sc.nextInt() + 100;
			x2 = sc.nextInt() + 100;
			y2 = sc.nextInt() + 100;
			visited = new int[N + 1][N + 1][2];
			Queue<int[]> queue = new LinkedList<>();

			queue.offer(new int[] { x1, y1, 0, 0 });
			queue.offer(new int[] { x1, y1, 0, 1 }); // 거리 방향
			visited[x1][y1][0] = 1;
			visited[x1][y1][1] = 1;
			int value = -1;
			// -----------------------------------------
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				int r = cur[0];
				int c = cur[1];
				int cnt = cur[2];
				int dir = cur[3];
				if (r == x2 && c == y2) {
					value = cnt;
					break;
				}
				for (int d = 1; d < 4; d += 2) {
					int s = (dir + d) % 4; // 이전 방향이 0(상하)인 경우 다음은 좌우로 보내고
					int u = (dir + d) % 2; // 이전 방향이 0(상하)이면 1(좌우)로 1이면 0으로 바꿔주는 코드
					int nr = r + dr[s];
					int nc = c + dc[s];
					if (!check(nr, nc))
						continue;
					if (visited[nr][nc][u] == 0) {// 방문하지 않았으면
						visited[nr][nc][u] = 1;
						queue.offer(new int[] { nr, nc, cnt + 1, u });
					}
				}
			}

			System.out.println("#" + t + " " + value);
		}

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N + 1 && nc >= 0 && nc < N + 1;
	}

}
