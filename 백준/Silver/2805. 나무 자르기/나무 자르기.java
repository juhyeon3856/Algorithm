import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] data = new int[N];

		long max = 0;
		long min = 0;
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			max = max > data[i] ? max : data[i];
		}


		while (min+1 < max) {
			long mid = (min + max) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				sum += data[i] > mid ? data[i] - mid : 0;
			}
			if (sum > M) {
				min = mid;
			} else if (sum < M) {
				max = mid;
			} else {
				min = mid;
				break;
			}
		}

		System.out.println(min);

	}

}
