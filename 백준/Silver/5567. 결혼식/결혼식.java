import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] list;
	static int N, M, answer;
	static boolean[] visited;
	static ArrayDeque<Integer> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		answer = 0;
		list = new ArrayList[N];
		queue = new ArrayDeque<>();
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			list[a].add(b);
			list[b].add(a);
		}

		visited[0] = true;
		for (int next : list[0]) {
			if (!visited[next]) {
				visited[next] = true;
				queue.offer(next);
				answer++;
			}
		}
		while (!queue.isEmpty()) {
			int q = queue.poll();
			for (int next : list[q]) {
				if (!visited[next]) {
					visited[next] = true;
					answer++;
				}
			}
		}
		System.out.println(answer);

	}

}
