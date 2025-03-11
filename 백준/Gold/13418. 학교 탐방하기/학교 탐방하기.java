import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static PriorityQueue<int[]> queue0, queue1;
	static List<int[]>[] tree;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		queue0 = new PriorityQueue<int[]>((o1, o2) -> (Integer.compare(o1[1], o2[1]))); // 0이 먼저 나
		queue1 = new PriorityQueue<int[]>((o1, o2) -> (Integer.compare(o2[1], o1[1]))); // 1 먼저 나옴
		tree = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			tree[a].add(new int[] { b, c }); // 어디로, 오르막0 또는 내리막1
//			tree[b].add(new int[] { a, (c + 1) % 2 });
			tree[b].add(new int[] { a, c });
		}

		visited = new boolean[N + 1];
		queue0.offer(tree[0].get(0));
		visited[0] = true;
//		visited[tree[0].get(0)[0]] = true;
		int cnt = 0;
		int upMax = 0;
		while (cnt != N) {
			int[] q = queue0.poll();
			if(visited[q[0]]) continue;
			visited[q[0]] = true;
//			System.out.println(Arrays.toString(q));
//			System.out.println(Arrays.toString(visited));
			cnt++;
			if (q[1] == 0)
				upMax++;
			for (int[] next : tree[q[0]]) {
				if (visited[next[0]])
					continue;
				queue0.offer(next);
//				visited[next[0]] = true;
			}
		}

		visited = new boolean[N + 1];
		queue1.offer(tree[0].get(0));
		visited[0] = true;
//		visited[tree[0].get(0)[0]] = true;
		cnt = 0;
		int upMin = 0;
		while (cnt != N) {
			int[] q = queue1.poll();
			if(visited[q[0]]) continue;
			visited[q[0]] = true;
//			System.out.println(Arrays.toString(q));
//			System.out.println(Arrays.toString(visited));
			cnt++;
			if (q[1] == 0)
				upMin++;
			for (int[] next : tree[q[0]]) {
				if (visited[next[0]])
					continue;
				queue1.offer(next);
//				System.out.println("next : " + Arrays.toString(next));
			}
		}
		System.out.println(upMax * upMax - upMin * upMin);
//		long a = (long) Math.pow(upMax, upMin);

	}

}
