import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, answer;
	static int[] p;
	static PriorityQueue<Edge> points;

	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;

		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		answer = 0;
		p = new int[V + 1];
		points = new PriorityQueue<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s, e, w));
		}

		makeset();

		int edgeCnt = 0;
		int max = 0;

		while (edgeCnt < V - 1) {
			Edge edge = points.poll();
			if (union(edge.s, edge.e)) {
				edgeCnt++;
				answer += edge.w;
				if (max < edge.w)
					max = edge.w;
			}
		}
		System.out.println(answer - max);
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		if (x < y) {
			p[y] = x;
		} else {
			p[x] = y;
		}
		return true;
	}

	private static int find(int x) {
		if (x == p[x])
			return x;
		return p[x] = find(p[x]);
	}

	private static void makeset() {
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}

	}

}
