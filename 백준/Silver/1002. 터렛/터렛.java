import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			float x1 = Integer.parseInt(st.nextToken());
			float y1 = Integer.parseInt(st.nextToken());
			float r1 = Integer.parseInt(st.nextToken());
			float x2 = Integer.parseInt(st.nextToken());
			float y2 = Integer.parseInt(st.nextToken());
			float r2 = Integer.parseInt(st.nextToken());
			float d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
			float r = (r1 + r2) * (r1 + r2);
			if (d == 0) {
				if (r1 == r2) {
					sb.append(-1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (Math.sqrt(d) + r1 < r2 || Math.sqrt(d) + r2 < r1) {
				sb.append(0).append("\n");
			} else if (Math.sqrt(d) + r1 == r2 || Math.sqrt(d) + r2 == r1) {
				sb.append(1).append("\n");
			} else if (d < r) {
				sb.append(2).append("\n");
			} else if (d == r) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);

	}

}
