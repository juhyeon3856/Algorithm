import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] data = new int[N][M];
		int[][] visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = 4000;
			}
		}
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		for (int i = 0; i < M; i++) {
			queue.offer(new int[] { 0, i, data[0][i], -2 });
		}
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[0] == N - 1) {
				System.out.println(q[2]);
				break;
			}
			for (int i = -1; i < 2; i++) {
				int nr = q[0] + 1;
				int nc = q[1] + i;
				if (i == q[3])
					continue;
				if (nc < 0 || nc >= M)
					continue;
//				if (visited[nr][nc] <= q[2] + data[nr][nc])
//					continue;
				visited[nr][nc] = q[2] + data[nr][nc];
				queue.offer(new int[] { nr, nc, q[2] + data[nr][nc], i });
			}
		}
//		for (int j = 0; j < visited.length; j++) {
//			System.out.println(Arrays.toString(visited[j]));
//
//		}

	}
}
