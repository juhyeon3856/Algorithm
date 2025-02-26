import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int N, M, cnt;
	static int[][] visited;
	static Map<Character, Integer> dir; // 상우하좌 0123
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[N][M];

		dir = new HashMap<>();
		dir.put('U', 0);
		dir.put('R', 1);
		dir.put('D', 2);
		dir.put('L', 3);
		cnt = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		makeSet();

		// 입력완료 로직 시작!!!
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int d = dir.get(map[i][j]);
				union(i, j, i + dr[d], j + dc[d]);
			}
		}

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				find(i, j);

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!set.contains(visited[i][j])) {
					cnt++;
					set.add(visited[i][j]);
				}

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!set.contains(visited[i][j])) {
					cnt++;
					set.add(visited[i][j]);
				}

			}
		}

		System.out.println(cnt);
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}

	}

	private static void union(int i, int j, int k, int l) {
		int x = find(i, j);
		int y = find(k, l);
//		System.out.println("x : " + x);
//		System.out.println("y : " + y);
		if (x == y)
			return;
		if (x > y) {
			visited[x / M][x % M] = y;
		} else {
			visited[y / M][y % M] = x;
		}
		return;
	}

	private static int find(int i, int j) {
		if (visited[i][j] == i * M + j)
			return i * M + j;
		return visited[i][j] = find(visited[i][j] / M, visited[i][j] % M);
	}

	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = i * M + j;
			}
		}
	}

}
