import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer, inf = Integer.MAX_VALUE / 10;
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], inf);
			dist[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			dist[s][e] = Math.min(w, dist[s][e]);
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dist[i][j] != inf) {
					sb.append(dist[i][j]).append(" ");
				} else {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}