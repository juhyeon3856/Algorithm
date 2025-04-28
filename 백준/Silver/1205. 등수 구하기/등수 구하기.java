import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int my = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		if (N > 0) {
			st = new StringTokenizer(br.readLine());
		}
		int answer = 1;
		int same = 0;
		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(st.nextToken());
			if (score > my) {
				answer++;
			} else if (score == my) {
				same++;
			}
		}
		if (answer + same > P) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}
