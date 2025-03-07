import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main  {

	static int[] startCount;
	static List<Integer>[] tree;
	static int N, M;
	static int[] answer;
	static ArrayDeque<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		startCount = new int[N];
		tree = new ArrayList[N];
		queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			startCount[b]++;
			tree[s].add(b);
		}
		for (int i = 0; i < N; i++) {
			if (startCount[i] == 0)
				queue.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		// 입력 완료 출력 시작
		while (!queue.isEmpty()) {
			int q = queue.poll();
			sb.append(q + 1).append(" ");
			for (int num : tree[q]) {
				startCount[num]--;
				if (startCount[num] == 0) {
					queue.offer(num);
				}
			}
		}
		System.out.println(sb);

	}
}
