import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N, sum, min, cnt;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		min = sum;
//		cnt = 0;
		combi(0, 0);
		System.out.println(min);
	}

	private static void combi(int depth, int start) {
		if (depth == N/2) {
			int tot1 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i] && visited[j])
						tot1 += map[i][j];
				}
			}
			int tot2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i] && !visited[j])
						tot2 += map[i][j];
				}
			}

			min = Math.min(min, Math.abs(tot1 - tot2));
//			System.out.println(Arrays.toString(visited));
//			System.out.println(min);
//			cnt++;
			return;
		}
		for (int i = start; i < N; i++) {
			visited[i] = true;
			combi(depth + 1, i + 1);
			visited[i] = false;
		}

	}

}