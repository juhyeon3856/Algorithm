import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, a, b, M, answer;
	static ArrayList<Integer>[] tree;
	static ArrayDeque<Integer> queue;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		queue = new ArrayDeque<Integer>();
		tree = new ArrayList[N + 1];
		answer = 0;
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			tree[p].add(c);
			tree[c].add(p);
		}

		queue.offer(a);
		visited[a] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int q = queue.poll();
				if (q == b) {
					System.out.println(answer);
					return;
				}
				for (int next : tree[q]) {
					if (visited[next])
						continue;
					queue.offer(next);
					visited[next] = true;
				}
			}
			answer++;
		}
		System.out.println(-1);

	}

}
