import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, X, answer;
	static int goCount, backCount;
	static ArrayList<int[]>[] goList, backList;
	static int[] gomin, backmin;
	static PriorityQueue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		goCount = 0;
		backCount = 0;
		goList = new ArrayList[N];
		backList = new ArrayList[N];
		gomin = new int[N];
		backmin = new int[N];
		Arrays.fill(gomin, Integer.MAX_VALUE);
		Arrays.fill(backmin, Integer.MAX_VALUE);
		queue = new PriorityQueue<int[]>((o1, o2) -> (Integer.compare(o1[1], o2[1])));

		for (int i = 0; i < N; i++) {
			goList[i] = new ArrayList<int[]>();
			backList[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			goList[s].add(new int[] { e, w });
			backList[e].add(new int[] { s, w });
		}

		queue.offer(new int[] { X, 0 });
		gomin[X] = 0;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			for (int[] next : goList[q[0]]) {
				int n = next[0];
				int w = next[1];
				if (gomin[n] > q[1] + w) {
					queue.offer(new int[] { n, q[1] + w });
					gomin[n] = q[1] + w;
				}
			}
		}
		queue.offer(new int[] { X, 0 });
		backmin[X] = 0;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			for (int[] next : backList[q[0]]) {
				int n = next[0];
				int w = next[1];
				if (backmin[n] > q[1] + w) {
					queue.offer(new int[] { n, q[1] + w });
					backmin[n] = q[1] + w;

				}
			}
		}
		for (int i = 0; i < N; i++) {
			answer = answer < gomin[i] + backmin[i] ? gomin[i] + backmin[i] : answer;
		}
		System.out.println(answer);

	}

}
