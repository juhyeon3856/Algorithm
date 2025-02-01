import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] tree = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[b].add(a);
		}

		int[] cntList = new int[N + 1];
		int[] isVisited = new int[N + 1];
		int max = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			isVisited[i] = i;
			for (int first : tree[i]) {
				if (isVisited[first] == i)
					continue;
				queue.add(first);
				cnt++;
				isVisited[first] = i;
			}

			while (!queue.isEmpty()) {
				int q = queue.poll();
				for (int trust : tree[q]) {
					if (isVisited[trust] == i)
						continue;
					if (tree[trust].isEmpty()) {
						isVisited[trust] = i;
						cnt++;
					} else {
						isVisited[trust] = i;
						queue.add(trust);
						cnt++;
					}
				}
			}
			cntList[i] = cnt;
			max = max < cnt ? cnt : max;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			if (cntList[i] == max) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);

	}
}
