import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int N, M, start;
	static List<Integer>[] link;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		start = Integer.parseInt(st.nextToken()) - 1;
		link = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			link[i] = new ArrayList<>(); // 각 정점의 인접 리스트 초기화
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			link[n1].add(n2);
			link[n2].add(n1);
		}
		////// 입력완료

		for (int i = 0; i < N; i++) {
			Collections.sort(link[i]);
		}

		visited = new boolean[N];
		dfs(start);
		System.out.println();
		visited = new boolean[N];
		bfs(start);

	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;

		do {
			int n = queue.poll();
			System.out.print(n + 1 + " ");
			for (int i = 0; i < link[n].size(); i++) {
				if (!visited[link[n].get(i)]) {
					visited[link[n].get(i)] = true;
					queue.add(link[n].get(i));
				}
			}
		} while (!queue.isEmpty());

	}

	private static void dfs(int n) {
		visited[n] = true;
		System.out.print(n + 1 + " ");
		for (int num : link[n]) {
			if (!visited[num]) {
				dfs(num);
			}
		}

	}

}
