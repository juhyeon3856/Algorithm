import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] tree;
	static int N, M, answer;
	static ArrayDeque<Integer> queue;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			tree[a].add(b);
			tree[b].add(a);
		}

		queue = new ArrayDeque<>();
		queue.offer(0);

		visited = new boolean[N];
		visited[0] = true;

		while (!queue.isEmpty()) {
			int q = queue.poll();
			for (int n : tree[q]) {
				if (!visited[n]) {
					queue.offer(n);
					visited[n] = true;
				}
			}
		}
		answer = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i])
				answer++;
		}
		System.out.println(answer - 1); // 1번 컴퓨터 제외

	}
}
