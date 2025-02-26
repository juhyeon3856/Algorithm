import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static long min;

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

	static PriorityQueue<Edge> points;
	static int[] p;
	static int[] r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		points = new PriorityQueue<>();
		p = new int[V + 1];
		r = new int[V + 1];
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s, e, w));
		}

		makeSet();
		min = 0L;
		int cnt = 0;
		while (cnt < V - 1) {
			Edge edge = points.poll();
			if (union(edge.s, edge.e)) {
				cnt++;
				min += edge.w;
			}
		}
		System.out.println(min);

	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		if (x > y) {
			r[x] += r[y];
			p[y] = x;
		} else {
			r[y] += r[x];
			p[x] = y;
		}
		return true;
	}

	private static int find(int x) {
		if (p[x] == x) {
			return x;
		} else {
			return p[x] = find(p[x]);
		}
	}

	private static void makeSet() {
		for (int i = 0; i <= V; i++) {
			p[i] = i;
			r[i] = 1;
		}

	}

}
