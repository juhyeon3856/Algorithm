import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, dist;
	static List<int[]> land;
	static int N, M, min, type;
	static ArrayDeque<int[]> queue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] visited;
	static PriorityQueue<int[]> pq;
	static int[] p, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		land = new LinkedList<>();
		map = new int[N][M];

		queue = new ArrayDeque<>();
		pq = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1[2], o2[2])));
		type = 2;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					land.add(new int[] { i, j });
			}
		}

		makeTeam();
//		printMap();

		dist = new int[type][type];
		for (int i = 2; i < type; i++) {
			Arrays.fill(dist[i], N + M);
		}

		int findSize = 0;
		int landSize = land.size();
		while (findSize < landSize) {
			findW(land.get(findSize++));
		}

//		printDist();
		makePQ();
		type -= 2;

		// 0부터 type까지 쿠르스칼
		p = new int[type];
		r = new int[type];

		makeSet();
		int cnt = 0;
		min = 0;
		while (!pq.isEmpty()) {
			int[] q = pq.poll();
			if (union(q[0], q[1])) {
				cnt++;
				min += q[2];
			}
		}
		if (cnt < type - 1) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		if (r[x] > r[y]) {
			r[x] += r[y];
			p[y] = x;
		} else {
			r[y] += r[x];
			p[x] = y;
		}
		return true;
	}

	private static int find(int x) {
		if (p[x] == x)
			return x;
		return p[x] = find(p[x]);
	}

	private static void makeSet() {
		for (int i = 0; i < type; i++) {
			p[i] = i;
			r[i] = 1;
		}

	}

	private static void makePQ() {
		for (int i = 2; i < type; i++) {
			for (int j = i + 1; j < type; j++) {
				if (dist[i][j] < N + M)
					pq.offer(new int[] { i - 2, j - 2, dist[i][j] - 1 });
			}
		}
	}

	private static void printDist() {
		for (int i = 0; i < type; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

	}

	private static void findW(int[] q) {
		int cr = q[0];
		int cc = q[1];
		int cm = map[cr][cc];
		for (int d = 0; d < 4; d++) {
			int nd = 1;
			while (true) {
				int nr = cr + dr[d] * nd;
				int nc = cc + dc[d] * nd;
				if (!check(nr, nc))
					break;
				int nm = map[nr][nc];
				if (nm == cm)
					break;
				if (nm != 0) {
					if (dist[nm][cm] > nd && nd > 2) {
						dist[nm][cm] = nd;
						dist[cm][nm] = nd;
					}
					break;
				}
				nd++;
			}
		}
	}

	private static void makeTeam() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					queue.offer(new int[] { i, j });
					map[i][j] = type;
					findTeam(type++);
				}
			}
		}

	}

	private static void findTeam(int t) {
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == 1) {
					map[nr][nc] = t;
					queue.add(new int[] { nr, nc });
				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
