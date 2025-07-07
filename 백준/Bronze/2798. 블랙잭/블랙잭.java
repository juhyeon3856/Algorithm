import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static int N, M, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 초기화
		p = new int[N];

		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 완료 로직 시작!!

		combi(0, 0, 0, 0);
		System.out.println(sum);
	}

	private static void combi(int depth, int start, int tot, int flag) {
		if (depth == 3) {
			if (tot <= M && tot > sum)
				sum = tot;
			return;
		}
		for (int i = start; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			combi(depth + 1, i, tot + p[i], flag | 1 << i);
		}
	}

}
