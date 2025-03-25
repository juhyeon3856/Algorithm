import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer, dest;
	static int[] indeg;
	static ArrayList<Integer>[] list;
	static int[] weight, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = 0;
			indeg = new int[N];
			list = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}
			weight = new int[N];
			max = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				list[a].add(b);
				indeg[b]++;
			}
			dest = Integer.parseInt(br.readLine()) - 1;

			ArrayDeque<int[]> queue = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				if (indeg[i] == 0) {
					queue.offer(new int[] { i, weight[i] });
					max[i] = weight[i];
				}
			}

			while (!queue.isEmpty()) {
				int[] q = queue.poll();
				for (int next : list[q[0]]) {
					max[next] = max[next] < q[1] + weight[next] ? q[1] + weight[next] : max[next];
					if (--indeg[next] == 0) {
						queue.offer(new int[] { next, max[next]});
					}
				}
			}
			System.out.println(max[dest]);

		}
	}
}
