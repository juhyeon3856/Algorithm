import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			long answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[] data = new int[N];
			int max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = N - 1; i >= 0; i--) {
				max = Math.max(max, data[i]);
				answer += Math.max(0, max - data[i]);
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}
}
