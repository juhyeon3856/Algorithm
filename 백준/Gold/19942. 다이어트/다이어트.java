import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, minPay = Integer.MAX_VALUE, minFlag;
	static int mp, mf, ms, mv;
	static int[][] data;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());

		data = new int[N][5];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
			data[i][2] = Integer.parseInt(st.nextToken());
			data[i][3] = Integer.parseInt(st.nextToken());
			data[i][4] = Integer.parseInt(st.nextToken());
		}

		// 경우의 수 보기
		subset(0, 0, 0, 0, 0, 0, 0);

		// 출력
		if (minFlag == 0) {
			System.out.print(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(minPay).append("\n");
			for (int i = 0; i < N; i++) {
				if ((minFlag & (1 << i)) > 0) {
					sb.append(i + 1).append(" ");
				}
			}
			System.out.println(sb);
		}
	}

	private static void subset(int depth, int p, int f, int s, int v, int pay, int flag) {
		if (depth == N) {
			if (!check(p, f, s, v))
				return;
			if (pay > minPay)
				return;
			if (pay == minPay && (((1 << (31 - Integer.numberOfLeadingZeros(flag) + 1)) - 1) & minFlag) != flag)
				return;
			minPay = pay;
			minFlag = flag;
			return;
		}
		subset(depth + 1, p + data[depth][0], f + data[depth][1], s + data[depth][2], v + data[depth][3],
				pay + data[depth][4], flag | (1 << depth));
		subset(depth + 1, p, f, s, v, pay, flag);
	}

	private static boolean check(int p, int f, int s, int v) {
		return p >= mp && f >= mf && s >= ms && v >= mv;
	}

}
