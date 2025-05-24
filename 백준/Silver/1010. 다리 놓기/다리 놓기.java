import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			double answer = 1;
			for (int i = n - r + 1; i <= n; i++) {
				answer *= i;
			}
			for (int i = 2; i <= r; i++) {
				answer /= i;
			}
			sb.append(Math.round(answer)).append("\n");
		}
		System.out.println(sb);

	}

}
