import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static PriorityQueue<int[]> queue;
	static ArrayList<int[]>[] list;
	static int[] visitedCount, visited, answer;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visitedCount = new int[N + 1];
		answer = new int[N + 1];
		visited = new int[N + 1];
		Arrays.fill(answer, -1);
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new int[] { b, w });
		}

		queue = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1[1], o2[1])));
		queue.offer(new int[] { 1, 0 });
		visited[1] = 0;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int prev = q[0];
			int w = q[1];
			if (++visitedCount[prev] == K) {
				answer[prev] = w;
			}
			if (visitedCount[prev] > K) {
				continue;
			}
			for (int[] next : list[prev]) {
				queue.offer(new int[] { next[0], w + next[1] });
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);

	}
}
