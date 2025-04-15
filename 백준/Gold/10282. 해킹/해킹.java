import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int T, N, D, start, count, time, num;
	static List<int[]>[] tree;
	static int[] times;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			tree = new ArrayList[N + 1];
			times = new int[N + 1];
			num = N;
			visited = new boolean[N + 1];
			Arrays.fill(times, Integer.MAX_VALUE);
			count = 0;
			time = 0;
			for (int i = 1; i <= N; i++) {
				tree[i] = new ArrayList<>();
			}

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				tree[e].add(new int[] { s, w });
			}

			PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1[1], o2[1])));
			queue.offer(new int[] { start, 0 });
			times[start] = 0;
			while (!queue.isEmpty()) {
				int[] q = queue.poll();
//				System.out.println(Arrays.toString(q));
				if (visited[q[0]]) {
					continue;
				} else {
					visited[q[0]] = true;
					time = Math.max(time, q[1]);
					count++;
					for (int[] next : tree[q[0]]) {
						if (times[next[0]] < next[1] + q[1])
							continue;
						queue.offer(new int[] { next[0], next[1] + q[1] });
					}
				}
			}
			System.out.println(count + " " + time);
		}
	}
}