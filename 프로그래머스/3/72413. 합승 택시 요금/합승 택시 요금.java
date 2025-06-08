import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

	static ArrayList<int[]>[] pay;
	static int N, S, A, B, answer;
	static int inf = Integer.MAX_VALUE;

	public int solution(int n, int s, int a, int b, int[][] fares) {
		N = n;
		S = s;
		A = a;
		B = b;
		// 인접 리스트 생성
		pay = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			pay[i] = new ArrayList<int[]>();
		}

		for (int[] fare : fares) {
			int n1 = fare[0];
			int n2 = fare[1];
			int w = fare[2];

			pay[n1].add(new int[] {n2, w});
			pay[n2].add(new int[] {n1, w});
		}

		// 정답 초기화 (정답보다 작으면 갱신)
		answer = inf;

		// 1부터 n까지 같이 가는 것으로 하고 그 이후에는 각자 가는 것으로 함.
		for (int i = 1; i <= n; i++) {
			answer = Math.min(dijkstra(i), answer);
		}
		return answer;
	}

	public int dijkstra(int s) {
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		int[] visited = new int[N + 1];
		Arrays.fill(visited, inf);

		queue.offer(new int[] { s, 0 });
		visited[s] = 0;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cn = q[0];
			int cw = q[1];
			for (int[] p : pay[cn]) {
				if (cw + p[1] < answer && cw + p[1] < visited[p[0]]) {
					queue.offer(new int[] { p[0], cw + p[1] });
					visited[p[0]] = cw + p[1];
				}
			}
		}
		if(visited[S] == inf || visited[A] == inf || visited[B] == inf){
			return inf;
		}
		return visited[S] + visited[A] + visited[B];
	}

}
