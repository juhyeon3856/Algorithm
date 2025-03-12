import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main  {
	static int V, E, start, inf;
	static PriorityQueue<int[]> queue;
	static List<int[]>[] tree;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		start = Integer.parseInt(br.readLine()) - 1;

		queue = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1[1], o2[1])));
		tree = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			tree[i] = new ArrayList<>();
		}
		answer = new int[V];
		inf = 10 * V + 100;
		Arrays.fill(answer, inf);
		answer[start] = 0;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			tree[s].add(new int[] { e, w });
		}

		queue.offer(new int[] { start, 0 });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			for (int[] next : tree[q[0]]) {
				if (q[1] + next[1] < answer[next[0]]) {
					answer[next[0]] = q[1] + next[1];
					queue.offer(new int[] { next[0], answer[next[0]] });
				}
			}
		}
		for (int i = 0; i < V; i++) {
			if (answer[i] == inf) {
				System.out.println("INF");
			} else {
				System.out.println(answer[i]);
			}
		}
	}

}
