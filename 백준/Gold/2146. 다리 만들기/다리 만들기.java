import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, dist;
	static List<int[]> land, typeStart;
	static int N, min, type;
	static ArrayDeque<int[]> queue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[] connected;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		land = new ArrayList<>();
		min = Integer.MAX_VALUE;
		queue = new ArrayDeque<>();
		type = 2;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					land.add(new int[] { i, j });
			}
		}

		typeStart = new ArrayList<>();
		typeStart.add(null);
		typeStart.add(null); // 인덱스 맞추기/

		makeTeam();
//		printMap();

		dist = new int[type][type];
		for (int i = 2; i < type; i++) {
			Arrays.fill(dist[i], N + N);
		}

		for (int t = 2; t < type; t++) {
			int[] s = typeStart.get(t);
			connected = new boolean[type];
			visited = new int[N][N];
			connected[t] = true;
			visited[s[0]][s[1]] = 1;
			queue.offer(s);
			findW(t);
		}

//		printDist();
		System.out.println(min - 1);

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

	private static void findW(int t) {
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			for (int d = 0; d < 4; d++) {

				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];
				int cd = q[2];
				if (!check(nr, nc))
					continue;

				int v = visited[nr][nc];
				int m = map[nr][nc];

				// v가 0이면 간적 없는곳 -> 감
				// 근데 m이 0이면 +1하면서 감
				// m이 t랑 같으면 +1안하고 가기
				// m이 0도 아니고 t랑 같지도 않으면 dist업데이트
				// v가 0이 아니면 -> 간적있긴함
				// 근데 cd가 더 작으면 가야함
				// m이 0이면 +1하면서 감
				// m이 t랑 같으면 +1안하고 감
				// m이 0도 아니고 t도 아니면 dist업데이트

				if (v == 0) {
					if (m == 0) {
						visited[nr][nc] = cd;
						queue.offer(new int[] { nr, nc, cd + 1 });
					} else if (m == t) {
						visited[nr][nc] = cd;
						queue.offer(new int[] { nr, nc, cd });
					} else {
						if (dist[t][m] > cd) {
							dist[t][m] = cd;
							dist[m][t] = cd;
							visited[nr][nc] = cd;
							min = min > cd ? cd : min;
						}
					}
				} else if (cd < v) {
					if (m == 0) {
						visited[nr][nc] = cd;
						queue.offer(new int[] { nr, nc, cd + 1 });
					} else if (m == t) {
						visited[nr][nc] = cd;
						queue.offer(new int[] { nr, nc, cd });
					} else {
						if (dist[t][m] > cd) {
							dist[t][m] = cd;
							dist[m][t] = cd;
							visited[nr][nc] = cd;
							min = min > cd ? cd : min;
						}
					}
				}

//				if (visited[nr][nc] != 0 && visited[nr][nc] <= cd) {
//					continue;
//				}
//				if (m == 0) {
//					queue.add(new int[] { nr, nc, cd + 1 });
//					visited[nr][nc] = cd;
//				}
//				if (dist[t][m] > cd) {
//					dist[t][m] = cd;
//					dist[m][t] = cd;
//					connected[m] = true;
//					visited[nr][nc] = cd;
//				}
//
//				if (connected[m] && dist[t][m] == N + N) {
//					queue.offer(new int[] { nr, nc, cd });
//					visited[nr][nc] = cd;
//				}
			}

		}

	}

	private static void makeTeam() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					queue.offer(new int[] { i, j });
					typeStart.add(new int[] { i, j, 1 });
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
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
