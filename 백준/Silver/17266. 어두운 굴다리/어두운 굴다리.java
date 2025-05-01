import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev = Integer.parseInt(st.nextToken());
		int answer = prev;
		for (int i = 1; i < N; i++) {
			int next = Integer.parseInt(st.nextToken());
			answer = Math.max(answer, (next - prev + 1) / 2);
			prev = next;
		}
		System.out.println(Math.max(answer, L - prev));
	}
}
