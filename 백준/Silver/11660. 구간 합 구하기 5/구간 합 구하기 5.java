import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] sum = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = 0;
			for (int j = 1; j <= N; j++) {
				if (i == 0) {
					s += Integer.parseInt(st.nextToken());
					sum[i][j] = s;
				} else {
					s += Integer.parseInt(st.nextToken());
					sum[i][j] = sum[i - 1][j] + s;
				}
			}
		}


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken())-1;
			int c1 = Integer.parseInt(st.nextToken())-1;
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			System.out.println(sum[r2][c2] + sum[r1][c1] - sum[r1][c2] - sum[r2][c1]);

		}

	}

}
