import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {
	static boolean[][] paper;
	static int N = 100, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		paper = new boolean[N][N];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			write(a, b);

		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (paper[i][j])
					answer++;
			}
		}
		System.out.println(answer);
	}

	private static void write(int a, int b) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				paper[a + i][b + j] = true;
			}
		}
	}
}
