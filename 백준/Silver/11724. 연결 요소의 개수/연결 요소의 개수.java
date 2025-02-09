import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static List<Integer>[] tree;
	static int N, M, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new LinkedList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
				tree[u].add(v);
				tree[v].add(u);
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				go(i);
				visited[i] = true;
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void go(int start) {
		for (int n : tree[start]) {
			if (!visited[n]) {
				visited[n] = true;
				go(n);
			}
		}
	}
}
