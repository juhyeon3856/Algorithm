import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K, N;
	static long min, max, mid;
	static long[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		max = Integer.MAX_VALUE;
		p = new long[K];
		for (int i = 0; i < K; i++) {
			p[i] = Long.parseLong(br.readLine());
			max = max < p[i] ? p[i] : max;

		}
		min = 0;
		mid = (min + max) / 2;

		while (min < mid && max > mid) {
			if (isMake()) {
				min = mid;
				mid = (min + max) / 2;
			} else {
				max = mid;
				mid = (min + max) / 2;
			}
		}
		mid++;
		if(isMake()) {
			System.out.println(mid);
		} else {
			System.out.println(mid-1);
		}
		

	}

	private static boolean isMake() {
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			cnt += p[i] / mid;
		}
		return cnt >= N;
	}

}
