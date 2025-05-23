import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int xo = Integer.parseInt(st.nextToken());
				int yo = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				if ((x1 - xo) * (x1 - xo) + (y1 - yo) * (y1 - yo) < r * r
						^ (x2 - xo) * (x2 - xo) + (y2 - yo) * (y2 - yo) < r * r) {
					answer++;
				}
				;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}

}
