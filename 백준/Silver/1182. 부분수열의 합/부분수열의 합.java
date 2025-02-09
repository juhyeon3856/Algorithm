import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, S, answer;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = new int[N];
		answer = S == 0 ? -1 : 0; // 아무것도 선택되지 않은 경우 제외
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		/// 입력완 로직시작----

		subset(0, 0);
		System.out.println(answer);
	}

	private static void subset(int cnt, int tot) {
		if (cnt == N) {
			if (tot == S) {
				answer++;
			}
			return;
		}
		subset(cnt + 1, tot + p[cnt]);
		subset(cnt + 1, tot);

	}

}
