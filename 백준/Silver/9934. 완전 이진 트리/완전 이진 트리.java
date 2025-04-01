import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static int N, N2;
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		N2 = 1 << N;
		p = new int[N2];

		st = new StringTokenizer(br.readLine());

		dfs(1);
//		System.out.println(Arrays.toString(p));

		int answer = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 1 << i; j++) {
				sb.append(p[answer++]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int idx) {
		if (idx * 2 >= N2) {
			p[idx] = Integer.parseInt(st.nextToken());
			return;
		}
		dfs(idx * 2);
		p[idx] = Integer.parseInt(st.nextToken());
		dfs(idx * 2 + 1);
	}

}
