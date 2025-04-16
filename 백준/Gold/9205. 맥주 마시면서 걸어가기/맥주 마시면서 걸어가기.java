import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] input; // home, store1~n, festival
	static List<Integer>[] list;
	static int[] nums;
	static ArrayDeque<Integer> queue;
	static boolean[] visited;
	static boolean isHappy;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			input = new int[N + 2][2];
			nums = new int[2];
			list = new ArrayList[N + 2];

			for (int i = 0; i < N + 2; i++) {
				list[i] = new ArrayList<Integer>();
				StringTokenizer st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
			}
			// 입력 완료 로직 시작!

			// list만들기
			combi(0, 0);

//			System.out.println(Arrays.deepToString(input));
//			System.out.println(Arrays.toString((list)));

			// 갈 수 있는지 확인
			queue = new ArrayDeque<>();
			visited = new boolean[N + 2];
			queue.offer(0);
			visited[0] = true;
			isHappy = false;

			while (!queue.isEmpty()) {
				int q = queue.poll();
				if (q == N + 1) {
					isHappy = true;
					break;
				}
				for (int next : list[q]) {
					if (visited[next])
						continue;
					queue.offer(next);
					visited[next] = true;
				}
			}
			if(isHappy) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
		}
		System.out.println(sb);
	}

	private static void combi(int depth, int start) {
		if (depth == 2) {
//			System.out.println(Arrays.toString(nums));
			if (Math.abs(input[nums[0]][0] - input[nums[1]][0])
					+ Math.abs(input[nums[0]][1] - input[nums[1]][1]) <= 1000) {
				list[nums[0]].add(nums[1]);
				list[nums[1]].add(nums[0]);
			}
			return;
		}
		for (int i = start; i < N + 2; i++) {
			nums[depth] = i;
			combi(depth + 1, i + 1);
		}

	}
}