import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static long min, max, mid;
	static int[] data;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		min = 0;
		max = Long.MAX_VALUE;
		mid = (min + max) / 2;

		data = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		// 이분 탐색
		while (min + 1 < max) {
			mid = (min + max) / 2;
			// 체크 로직 : k * Σ 1/k_i >= M 를 만족하는 가장 작은 k값을 찾아야 함.
			long calc = 0;
			for (int i = 0; i < N; i++) {
				calc += mid / data[i];
				// 오버플로우 나면 M보다 큰 것
				if (calc < 0) {
					break;
				}
			}

			if (calc > 0 && calc < M) { // k가 더 커져야 함
				min = mid;
			} else {
				max = mid;
			}
			int a = 0;
		}
		System.out.println(max);
	}

}
