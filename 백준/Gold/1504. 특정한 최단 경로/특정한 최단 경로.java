import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer;
	static PriorityQueue<int[]> queue;
	static ArrayList<int[]>[] list;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new int[N + 1];
		answer = 0;
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new int[] { b, w });
			list[b].add(new int[] { a, w });
		}

		st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

//		System.out.println("num1 : " + num1);
//		System.out.println("num2 : " + num2);

		queue = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1[1], o2[1])));

		boolean can12 = true;
		int answer12 = 0;
		int result = sortPath(1, num1);
		if (result >= 0) {
			answer12 += result;
		} else {
			can12 = false;
		}
		result = sortPath(num1, num2);
		if (result >= 0) {
			answer12 += result;
		} else {
			can12 = false;
		}
		result = sortPath(num2, N);
		if (result >= 0) {
			answer12 += result;
		} else {
			can12 = false;
		}

		int answer21 = 0;
		boolean can21 = true;

		result = sortPath(1, num2);
		if (result >= 0) {
			answer21 += result;
		} else {
			can21 = false;
		}
		result = sortPath(num2, num1);
		if (result >= 0) {
			answer21 += result;
		} else {
			can21 = false;
		}
		result = sortPath(num1, N);
		if (result >= 0) {
			answer21 += result;
		} else {
			can21 = false;
		}

//		System.out.println(Arrays.toString(visited));
//		System.out.println(can12);
//		System.out.println(can21);

		// 출력
		if (can12) {
			if (can21) {
				System.out.println(answer12 > answer21 ? answer21 : answer12);
			} else {
				System.out.println(answer12);
			}
		} else {
			if (can21) {
				System.out.println(answer21);
			} else {
				System.out.println(-1);
			}
		}

	}

	private static int sortPath(int start, int end) {
		queue.clear();
		Arrays.fill(visited, Integer.MAX_VALUE);

//		System.out.println("start : " + start);
//		System.out.println("end : " + end);
		queue.offer(new int[] { start, 0 });
		visited[start] = 0;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
//			System.out.println(Arrays.toString(q));
			int prev = q[0];
			int w = q[1];
			if (prev == end) {
//				System.out.println("return : " + w);
//				System.out.println("-------------------------");
				return w;
			}
//			System.out.println("input start ---> ");
//			System.out.println("[   ");
			for (int[] next : list[prev]) {
				if (visited[next[0]] <= w + next[1])
					continue;
//				System.out.println("next[0] : " + next[0]);
//				System.out.println("w + next[1] : " + (w + next[1]));
				visited[next[0]] = w + next[1];
				queue.offer(new int[] { next[0], w + next[1] });
			}
//			System.out.println("  ]");
//			System.out.println("<------ input end");
		}
//		System.out.println("return : " + -1);
//		System.out.println("-------------------------");
		return -1;
	}

}
